import java.util.*

class EventSource {

    private val observers = LinkedList<System>()

    fun subscribe(system: System) {
        observers.add(system)
    }

    fun notify(event: Event) {
        observers.forEach {
            it.notify(event)
        }
    }
}
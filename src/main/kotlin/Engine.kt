import render.RendereSystem
import java.util.*

class Engine {

    private val eventQueue = LinkedList<Event>()
    private val eventSource = EventSource()
    private val componentStore = ComponentStore()

    fun init() {
        RendereSystem().init(eventSource, componentStore)
    }

    fun update(fps: Double) {
        eventQueue.add(TickEvent(fps))
        val iterator = eventQueue.iterator()
        while (iterator.hasNext()) {
            val event = iterator.next()
            iterator.remove()
            eventSource.notify(event)
            if (event is TickEvent) {
                return
            }
        }
    }
}
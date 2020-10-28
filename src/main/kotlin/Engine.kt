import render.BackgroundRenderer
import kotlin.reflect.KClass

class Engine {

    private val eventSystemMap = mutableMapOf<KClass<out Event>, System>()
    private val eventQueue = mutableListOf<Event>()

    fun init() {
        BackgroundRenderer().init(this)
    }

    fun registerForEvent(system: System, eventClass: KClass<out Event>) {
        eventSystemMap[eventClass] = system
    }

    fun update() {
        eventQueue.add(TickEvent())
        eventQueue.forEach {
            eventSystemMap[it::class]?.update(it)
        }
        eventQueue.clear()
    }
}
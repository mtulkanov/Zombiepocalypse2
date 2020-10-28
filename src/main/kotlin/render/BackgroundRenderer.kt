package render

import Engine
import Event
import System
import TickEvent

class BackgroundRenderer : System {

    override fun init(engine: Engine) {
        engine.registerForEvent(this, TickEvent::class)
    }

    override fun update(event: Event) {
        if (event is TickEvent) {
            println("BackgroundRenderer.update")
        }
    }
}
package com.mtulkanov.render

import com.mtulkanov.*

class RenderSystem : System {

    companion object {
        private const val title = ""
        private const val width = 1024
        private const val height = 768
    }

    private val display = Display(title, width, height)
    private val fpsCounter = FpsCounter(60)

    override fun init(eventSource: EventSource, componentStore: ComponentStore) {
        eventSource.subscribe(this)
        val entity = componentStore.createEntity()
        val component = RenderableComponent()
        componentStore.add(component, entity)
    }

    override fun notify(event: Event) {
        if (event is TickEvent) {
            handleTickEvent(event)
        }
    }

    private fun handleTickEvent(event: TickEvent) {
        fpsCounter.addDelta(event.delta)
        if (fpsCounter.isFpsReady()) {
            val title = "Current fps: %.2f".format(fpsCounter.getFps())
            display.updateTitle(title)
        }
    }
}
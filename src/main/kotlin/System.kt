interface System {
    fun init(eventSource: EventSource, componentStore: ComponentStore)
    fun notify(event: Event)
}
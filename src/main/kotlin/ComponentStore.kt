class ComponentStore {

    private var nextEntity = 0
        get() = field++

    private val entities = mutableMapOf<Int, MutableList<Component>>()

    fun createEntity(): Int {
        return nextEntity
    }

    fun add(component: Component, entity: Int) {
        entities.putIfAbsent(entity, mutableListOf())
        entities[entity]?.add(component)
    }
}
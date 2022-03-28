package structures

class BasicHashTable<T, R>(private var capacity: Int = 0) {
    private data class Node<T, R>(val key: T, val value: R)

    private var map = arrayOfNulls<Node<T, R>?>(this.capacity)

    fun push(key: T, value: R) {
        this.map[calculateHash(key)] = Node(key, value)
    }

    fun get(key: T) : R? {
        return this.map[calculateHash(key)]?.value
    }

    fun remove(key: T) {
        this.map[calculateHash(key)] = null
    }

    private fun calculateHash(key: T) : Int {
        return key.hashCode() % this.capacity
    }
}

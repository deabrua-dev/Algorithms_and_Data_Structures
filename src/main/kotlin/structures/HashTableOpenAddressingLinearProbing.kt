package structures

class HashTableOpenAddressingLinearProbing<T, R>(private var capacity: Int = 0) {
    private data class Node<T, R>(val key: T, val value: R, var deleted: Boolean = false)

    private var map = arrayOfNulls<Node<T, R>?>(this.capacity)
    private var size = 0

    fun size() = this.size
    fun capacity() = this.capacity

    fun push(key: T, value: R) {
        var hashIndex = calculateHash(key)
        var magicConstant = 1
        while (
            this.map[hashIndex] != null &&
            this.map[hashIndex]?.key == key &&
            this.map[hashIndex]?.deleted != true
        ) {
            hashIndex = (hashIndex + magicConstant) % this.capacity
            magicConstant++
        }
        if (
            this.map[hashIndex] == null &&
            this.map[hashIndex]?.deleted != true
        ) {
            this.size++
        }
        this.map[hashIndex] = Node(key, value)
    }

    fun get(key: T) : R? {
        var hashIndex = calculateHash(key)
        var magicConstant = 1
        while (this.map[hashIndex] != null) {
            if (
                this.map[hashIndex]?.key == key &&
                this.map[hashIndex]?.deleted != true
            ) {
                return this.map[hashIndex]?.value
            } else if (this.map[hashIndex] != null) {
                break
            }
            hashIndex = (hashIndex + magicConstant) % this.capacity
            magicConstant++
        }
        return null
    }

    fun remove(key: T) {
        var hashIndex = calculateHash(key)
        var magicConstant = 1
        while (this.map[hashIndex] != null) {
            if (this.map[hashIndex]!!.key == key) {
                this.map[hashIndex]!!.deleted = true
                break
            } else if (this.map[hashIndex] != null) {
                break
            }
            hashIndex = (hashIndex + magicConstant) % this.capacity
            magicConstant++
        }
        this.size--
    }

    private fun calculateHash(key: T) : Int {
        return key.hashCode() % this.capacity
    }
}

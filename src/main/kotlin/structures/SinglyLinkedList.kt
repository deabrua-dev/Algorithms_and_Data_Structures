package structures

class SinglyLinkedList<T> {
    class Node<T> (
        private var value: T?,
        private var next: Node<T>? = null
    ) {
        fun data() = this.value
        fun next() = this.next

        fun changeData(value: T? = null) {
            this.value = value
        }

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var length: Int = 0

    fun length() = this.length
    fun isEmpty() = this.head == null

    fun push(value: T) {
        if (isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
        } else {
            val newNode = Node(value, this.head)
            this.head = newNode
        }
        this.length++
    }

    fun append(value: T) {
        if (isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
        } else {
            this.tail?.changeNext(Node(value))
            this.tail = this.tail?.next()
        }
        this.length++
    }

    fun insert(index: Int, value: T) {
        if (index < 0 || index > this.length) return
        if (index == 0) {
            this.head = Node(value, this.head)
            return
        }
        if (index == this.length) {
            this.append(value)
            return
        }
        val prevNode = this.getAt(index - 1)
        val nextNode = prevNode?.next()
        prevNode?.changeNext(Node(value, nextNode))
        this.length++
    }

    fun remove(index: Int) {
        if (index < 0 || index >= this.length) return
        if (index == 0) {
            this.head = this.head?.next()
            this.length--
            return
        }
        val prevNode = this.getAt(index - 1)
        val nextNode = prevNode?.next()?.next()
        prevNode?.changeNext(nextNode)
        this.length--
    }

    fun clear() {
        this.head = null
        this.tail = null
        this.length = 0
    }

    fun indexOf(value: T) : Int {
        for (index in 0 until this.length) {
            if (this.getAt(index)!!.data() == value) return index
        }
        return -1
    }

    fun lastIndexOf(value: T) : Int {
        var result = -1
        for (index in 0 until this.length) {
            if (this.getAt(index)!!.data() == value) result = index
        }
        return result
    }

    private fun getAt(index: Int) : Node<T>? {
        var temp = this.head
        var counter = 0
        while (counter != index) {
            temp = temp?.next()
            counter++
        }
        return temp
    }

    operator fun get(index: Int): T? = this.getAt(index)!!.data()
    operator fun set(index: Int, value: T) = this.getAt(index)!!.changeData(value)
}

package structures

class PriorityQueue<T> {
    class Node<T> (
        private var value: T?,
        private var priority: Int = 0,
        private var next: Node<T>? = null
    ) {
        fun data() = this.value
        fun priority() = this.priority
        fun next() = this.next

        fun changeNext(next: Node<T>? = null) {
            this.next = next
        }
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var length: Int = 0

    fun front() = this.head?.data()
    fun back() = this.tail?.data()

    fun length() = this.length
    fun isEmpty() = this.head == null

    fun push(value: T, priority: Int) {
        if (isEmpty()) {
            this.head = Node(value, priority)
            this.tail = this.head
        } else {
            var node = this.head
            val newNode = Node(value, priority)
            while (node!!.next() != null && node.next()!!.priority() <= priority) {
                node = node.next()
            }
            if (node.next() == null) this.tail = newNode
            newNode.changeNext(node.next())
            node.changeNext(newNode)
        }
        this.length++
    }

    fun pop() {
        if (isEmpty()) return
        this.head = this.head?.next()
        if (this.head == null) this.tail = null
        this.length--
    }
}

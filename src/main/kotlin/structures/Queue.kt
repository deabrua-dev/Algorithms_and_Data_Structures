package structures

class Queue<T> {
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

    fun front() = this.head?.data()
    fun back() = this.tail?.data()

    fun length() = this.length
    fun isEmpty() = this.head == null

    fun push(value: T) {
        if (isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
        } else {
            this.tail?.changeNext(Node(value))
            this.tail = this.tail?.next()
        }
        this.length++
    }

    fun pop() {
        if (isEmpty()) return
        this.head = this.head?.next()
        this.length--
    }
}
package structures

class Stack<T> {
    private class Node<T> (
        private var value: T?,
        private var next: Node<T>? = null
    ) {
        fun data() = this.value
        fun next() = this.next
    }

    private var head: Node<T>? = null
    private var length: Int = 0

    fun top() = this.head?.data()

    fun length() = this.length
    fun isEmpty() = this.head == null

    fun push(value: T) {
        if (isEmpty()) {
            this.head = Node(value)
        } else {
            val newNode = Node(value, this.head)
            this.head = newNode
        }
        this.length++
    }

    fun pop() {
        if (isEmpty()) return
        this.head = this.head?.next()
        this.length--
    }
}

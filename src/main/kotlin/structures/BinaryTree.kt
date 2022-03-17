package structures

class BinaryTree<T> {
    class Node<T>(
        private var data: T?,
        private var left: Node<T>? = null,
        private var right: Node<T>? = null
    ) {
        fun data() = this.data
        fun left() = this.left
        fun right() = this.right

        fun changeLeft(left: Node<T>? = null) {
            this.left = left
        }

        fun changeRight(right: Node<T>? = null) {
            this.right = right
        }
    }

    private var root: Node<T>? = null
    private var size = 0

    fun push(value: T) {
        if (this.root == null) {
            this.root = Node(value)
        } else {
            val queue = Queue<Node<T>>()
            queue.push(this.root!!)
            while (!queue.isEmpty()) {
                val node = queue.front()
                queue.pop()
                if (node?.right() == null) {
                    node?.changeRight(Node(value))
                    return
                } else if (node.left() == null) {
                    node.changeLeft(Node(value))
                    return
                } else {
                    queue.push(node.right()!!)
                    queue.push(node.left()!!)
                }
            }
        }
        this.size++
    }
}

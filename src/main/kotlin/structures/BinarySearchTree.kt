package structures

class BinarySearchTree<T, R: Comparable<R>> {
    private class Node<T, R: Comparable<R>>(
        private var data: T?,
        private val key: R?,
        private var left: Node<T, R>? = null,
        private var right: Node<T, R>? = null
    ) {
        fun data() = this.data
        fun key() = this.key
        fun left() = this.left
        fun right() = this.right

        fun changeLeft(left: Node<T, R>? = null) {
            this.left = left
        }

        fun changeRight(right: Node<T, R>? = null) {
            this.right = right
        }
    }

    private var root: Node<T, R>? = null
    private var size = 0

    fun push(value: T, key: R) {
        if (this.root == null) {
            this.root = Node(value, key)
        } else if (key >= this.root!!.key()!!) {
            if (this.root?.right() != null) {
                this.insert(this.root!!.right(), value, key)
            } else {
                this.root!!.changeRight(Node(value, key))
            }
        } else {
            if (this.root?.left() != null) {
                this.insert(this.root!!.left(), value, key)
            } else {
                this.root!!.changeLeft(Node(value, key))
            }
        }
        this.size++
    }

    private fun insert(node: Node<T, R>?, value: T, key: R) {
        if (key >= node!!.key()!!) {
            if (node.right() != null) {
                this.insert(node.right(), value, key)
            } else {
                node.changeRight(Node(value, key))
            }
        } else {
            if (node.left() != null) {
                this.insert(node.left(), value, key)
            } else {
                node.changeLeft(Node(value, key))
            }
        }
    }

    fun find(key: R) : T? {
        if (this.root == null) {
            throw NullPointerException()
        }
        if (this.root!!.key() == key) {
            return this.root!!.data()
        }
        if (key >= this.root!!.key()!!) {
            if (this.root?.right() != null) {
                return this.find(this.root!!.right(), key)
            } else {
                throw NullPointerException()
            }
        } else {
            if (this.root?.left() != null) {
                return this.find(this.root!!.left(), key)
            } else {
                throw NullPointerException()
            }
        }
    }

    private fun find(node: Node<T, R>?, key: R) : T? {
        if (node!!.key() == key) {
            return node.data()
        }
        if (key >= node.key()!!) {
            if (node.right() != null) {
                return this.find(node.right(), key)
            } else {
                throw NullPointerException()
            }
        } else {
            if (node.left() != null) {
                return this.find(node.left(), key)
            } else {
                throw NullPointerException()
            }
        }
    }
}

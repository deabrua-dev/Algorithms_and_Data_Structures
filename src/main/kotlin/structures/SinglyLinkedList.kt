package structures

class SinglyLinkedList<T> {
    class Node<T>(
        private var value: T,
        private var next: Node<T>? = null
    ) {
        fun data() = this.value
        fun next() = this.next

        fun changeData(value: T) {
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

    fun push(value: T) {
        if(isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
            this.length++
        } else {
            val newNode: Node<T> = Node(value, this.head)
            this.head = newNode
            this.length++
        }
    }

    fun append(value: T) {
        if(isEmpty()) {
            this.head = Node(value)
            this.tail = this.head
            this.length++
        } else {
            this.tail?.changeNext(Node(value))
            this.tail = this.tail?.next()
            this.length++
        }
    }

    fun insert(index: Int, value: T) {
        if(index < 0 || index > this.length) return
        if(index == 0) {
            this.push(value)
            return
        }
        if(index == this.length) {
            this.append(value)
            return
        }
        var temp: Node<T>? = this.head
        val newNode: Node<T> = Node(value)
        var counter: Int = 0
        while(counter != index - 1) {
            temp = temp?.next()
            counter++
        }
        newNode.changeNext(temp?.next())
        temp?.changeNext(newNode)
        this.length++
    }


    fun remove(index: Int) {
        if(index < 0 || index > this.length) return
        var currNode: Node<T>? = this.head
        var prevNode: Node<T>? = null
        if(index == 0) {
            this.head = this.head?.next()
            this.length--
            return
        }
        var counter: Int = 0
        while(counter != index) {
            prevNode = currNode
            currNode = prevNode?.next()
            counter++
        }
        prevNode?.changeNext(currNode?.next())
        if(index == this.length) this.tail = prevNode
        this.length--
    }

    fun clear() {
        this.head = null
        this.tail = null
        this.length = 0
    }

    fun isEmpty() = this.head == null

    fun indexOf(value: T) : Int {
        var temp: Node<T>? = this.head
        var counter: Int = 0
        while (counter != this.length) {
            if (temp!!.data() == value) return counter
            temp = temp.next()
            counter++
        }
        return -1
    }

    fun lastIndexOf(value: T) : Int {
        var temp: Node<T>? = this.head
        var counter: Int = 0
        var result: Int = -1
        while (counter != this.length) {
            if (temp!!.data() == value) result = counter
            temp = temp.next()
            counter++
        }
        return result
    }

    operator fun get(index: Int): T {
        var temp: Node<T>? = this.head
        var counter: Int = 0
        while (counter != index) {
            temp = temp?.next()
            counter++
        }
        return temp!!.data()
    }

    operator fun set(index: Int, value: T) {
        var temp: Node<T>? = this.head
        var counter: Int = 0
        while (counter != index) {
            temp = temp?.next()
            counter++
        }
        temp!!.changeData(value)
    }
}

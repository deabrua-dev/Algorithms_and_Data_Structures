package structures

class MinHeap(private val maxSize: Int = 0) {
    private var heap = Array<Int>(maxSize) { 0 }
    private var size = 0

    fun testGetHeap() = this.heap

    fun size() = this.size

    private fun leftChild(index: Int) = 2 * index + 1
    private fun rightChild(index: Int) = 2 * index + 2

    fun add(elem: Int) {
        if (this.heap.isEmpty()) return
        this.heap[this.size] = elem
        this.size++
        if (this.size > 1) {
            for (i in this.size / 2 downTo 0) {
                heapify(i)
            }
        }
    }

    fun peek() : Int {
        val result = this.heap[0]
        this.heap = this.heap.copyOfRange(1, this.heap.size)
        this.size--
        for (i in this.size / 2 downTo 0) {
            heapify(i)
        }
        return result
    }

    fun buildHeap(array: Array<Int>) {
        this.heap = array.clone()
        this.size = this.heap.size
        for (i in this.size / 2 downTo 0) {
            heapify(i)
        }
    }

    private fun heapify(index: Int) {
        var largest = index
        val l = leftChild(index)
        val r = rightChild(index)
        if (l < this.size && this.heap[l] < this.heap[largest]) { largest = l }
        if (r < this.size && this.heap[r] < this.heap[largest]) { largest = r }
        if (largest != index) {
            swap(index, largest)
            heapify(largest)
        }
    }

    private fun swap(leftIndex: Int, rightIndex: Int) {
        this.heap[leftIndex] = this.heap[rightIndex].also { this.heap[rightIndex] = this.heap[leftIndex] }
    }
}

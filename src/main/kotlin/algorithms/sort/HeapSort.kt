package algorithms.sort

fun <T: Comparable<T>> Array<T>.heapSort() {
    val array = this
    for (index in size / 2 downTo 0) {
        heapify(array, size, index)
    }
    for (index in size - 1 downTo 0) {
        array[0] = array[index].also { array[index] = array[0] }
        heapify(array, index, 0)
    }
}

private fun <T: Comparable<T>> heapify(array: Array<T>, size: Int, index: Int) {
    var largest = index
    val l = 2 * index + 1
    val r = 2 * index + 2
    if (l < size && array[l] > array[largest]) { largest = l }
    if (r < size && array[r] > array[largest]) { largest = r }
    if (largest != index) {
        array[largest] = array[index].also { array[index] = array[largest] }
        heapify(array, size, largest)
    }
}

fun <T: Comparable<T>> MutableList<T>.heapSort() {
    val list = this
    for (index in size / 2 downTo 0) {
        heapify(list, size, index)
    }
    for (index in size - 1 downTo 0) {
        list[0] = list[index].also { list[index] = list[0] }
        heapify(list, index, 0)
    }
}

private fun <T: Comparable<T>> heapify(list: MutableList<T>, size: Int, index: Int) {
    var largest = index
    val l = 2 * index + 1
    val r = 2 * index + 2
    if (l < size && list[l] > list[largest]) { largest = l }
    if (r < size && list[r] > list[largest]) { largest = r }
    if (largest != index) {
        list[largest] = list[index].also { list[index] = list[largest] }
        heapify(list, size, largest)
    }
}

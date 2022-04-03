package algorithms.sort

fun <T: Comparable<T>> Array<T>.quickSort() {
    startSort(this, 0, size - 1)
}

private fun <T: Comparable<T>> startSort(array: Array<T>, low: Int, high: Int) {
    if (high <= low) return
    val p = partition(array, low, high)

    startSort(array, low, p - 1)
    startSort(array, p + 1, high)
}

private fun <T: Comparable<T>> partition(array: Array<T>, low: Int, high: Int) : Int {
    var i = low
    var j = high + 1
    while (true) {
        while (array[++i] < array[low]) {
            if (i == high) break
        }
        while (array[--j] > array[low]) {
            if (j == low) break
        }
        if (i >= j) break
        array[i] = array[j].also { array[j] = array[i] }
    }
    array[low] = array[j].also { array[j] = array[low] }
    return j
}

fun <T: Comparable<T>> MutableList<T>.quickSort() {
    startSort(this, 0, size - 1)
}

private fun <T: Comparable<T>> startSort(list: MutableList<T>, low: Int, high: Int) {
    if (high <= low) return
    val p = partition(list, low, high)

    startSort(list, low, p - 1)
    startSort(list, p + 1, high)
}

private fun <T: Comparable<T>> partition(list: MutableList<T>, low: Int, high: Int) : Int {
    var i = low
    var j = high + 1
    while (true) {
        while (list[++i] < list[low]) {
            if (i == high) break
        }
        while (list[--j] > list[low]) {
            if (j == low) break
        }
        if (i >= j) break
        list[i] = list[j].also { list[j] = list[i] }
    }
    list[low] = list[j].also { list[j] = list[low] }
    return j
}
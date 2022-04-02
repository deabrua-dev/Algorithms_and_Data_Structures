package algorithms.sort

fun <T: Comparable<T>> Array<T>.mergeSort() {
    val test = startSort(this.toList())
    for (i in test.indices) {
        this[i] = test[i]
    }
}

private fun <T: Comparable<T>> startSort(array: List<T>) : List<T> {
    if (array.size <= 1) {
        return array.toList()
    }
    val mid = array.size / 2
    val left = array.subList(0, mid)
    val right = array.subList(mid, array.size)

    return merge(startSort(left), startSort(right))
}

private fun <T: Comparable<T>> merge(left: List<T>, right: List<T>) : List<T> {
    var leftIndex = 0
    var rightIndex = 0
    val result = arrayListOf<T>()
    while (leftIndex < left.size && rightIndex < right.size) {
        if (left[leftIndex] <= right[rightIndex]) {
            result.add(left[leftIndex])
            leftIndex++
        } else {
            result.add(right[rightIndex])
            rightIndex++
        }
    }
    while (leftIndex < left.size) {
        result.add(left[leftIndex])
        leftIndex++
    }
    while (rightIndex < right.size) {
        result.add(right[rightIndex])
        rightIndex++
    }
    return result
}

fun <T: Comparable<T>> MutableList<T>.mergeSort() {
    val test = startSort(this)
    for (i in test.indices) {
        this[i] = test[i]
    }
}


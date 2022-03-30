package algorithms.sort

fun <T: Comparable<T>> Array<T>.insertionSort() {
    val array = this
    for (i in 1 until size) {
        val x = array[i]
        var j = i
        while (j > 0 && array[j - 1] > x) {
            array[j] = array[j - 1]
            j--
        }
        array[j] = x
    }
}

fun <T: Comparable<T>> MutableList<T>.insertionSort() {
    val list = this
    for (i in 1 until size) {
        val x = list[i]
        var j = i
        while (j > 0 && list[j - 1] > x) {
            list[j] = list[j - 1]
            j--
        }
        list[j] = x
    }
}

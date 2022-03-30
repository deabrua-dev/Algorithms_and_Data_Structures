package algorithms.sort

fun <T: Comparable<T>> Array<T>.bubbleSort() {
    val array = this
    for (i in 0 until size - 1) {
        for (j in 0 until size - i - 1) {
            if (array[j + 1] < array[j]) {
                array[j + 1] = array[j].also { array[j] = array[j + 1] }
            }
        }
    }
}

fun <T: Comparable<T>> MutableList<T>.bubbleSort() {
    val list = this
    for (i in 0 until size - 1) {
        for (j in 0 until size - i - 1) {
            if (list[j + 1] < list[j]) {
                list[j + 1] = list[j].also { list[j] = list[j + 1] }
            }
        }
    }
}

package algorithms.sort

fun <T: Comparable<T>> Array<T>.selectionSort() {
    val array = this
    for (i in 0 until size - 1) {
        var min = i
        for (j in i + 1 until size) {
            if (array[j] < array[min]) {
                min = j
            }
        }
        if (min != i) {
            array[min] = array[i].also { array[i] = array[min] }
        }
    }
}

fun <T: Comparable<T>> MutableList<T>.selectionSort() {
    val list = this
    for (i in 0 until size - 1) {
        var min = i
        for (j in i + 1 until size) {
            if (list[j] < list[min]) {
                min = j
            }
        }
        if (min != i) {
            list[min] = list[i].also { list[i] = list[min] }
        }
    }
}

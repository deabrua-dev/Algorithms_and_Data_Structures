package algorithms.sort

fun <T: Comparable<T>> Array<T>.shellSort() {
    val array = this
    var h = 1
    while (h < size / 2) {
        h = 3 * h + 1
    }
    while (h > 0) {
        for (i in h until size) {
            var j = i
            while (j - h >= 0 && array[j] < array[j - h]) {
                array[j] = array[j - h].also { array[j - h] = array[j] }
                j -= h
            }
        }
        h = h / 3
    }
}

fun <T: Comparable<T>> MutableList<T>.shellSort() {
    val list = this
    var h = 1
    while (h < size / 2) {
        h = 3 * h + 1
    }
    while (h > 0) {
        for (i in h until size) {
            var j = i
            while (j - h >= 0&& list[j] < list[j - h]) {
                list[j] = list[j - h].also { list[j - h] = list[j] }
                j -= h
            }
        }
        h = h / 3
    }
}

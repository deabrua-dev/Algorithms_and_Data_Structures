package algorithms.search

fun <T: Comparable<T>> BinarySearch(list: List<T>, element: T) : Int {
    var left = 0
    var right = list.size - 1
    while (left <= right) {
        val middle = (left + right) / 2
        if (list[middle] < element) {
            left = middle + 1
        } else if (list[middle] > element) {
            right = middle - 1
        } else {
            return middle
        }
    }
    return -1
}

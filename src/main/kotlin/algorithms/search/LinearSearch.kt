package algorithms.search

fun <T: Comparable<T>> LinearSearch(list: List<T>, element: T) : Int {
    for (i in list.indices) {
        if (list[i] == element) {
            return i
        }
    }
    return -1
}

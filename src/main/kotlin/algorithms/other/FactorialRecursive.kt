package algorithms.other

fun factorial(num: Int) : Int {
    if (num == 0) return 1
    return num * factorial(num - 1)
}

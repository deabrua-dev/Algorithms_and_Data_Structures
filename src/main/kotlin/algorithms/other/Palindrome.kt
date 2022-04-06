package algorithms.other

fun String.isPalindrome() : Boolean {
    return this == this.reversed()
}

fun Int.isPalindrome() : Boolean {
    val num = this.toString()
    if (num.length == 1) return true
    return num == num.reversed()
}

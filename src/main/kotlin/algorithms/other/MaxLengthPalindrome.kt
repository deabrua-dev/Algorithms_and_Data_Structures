package algorithms.other

import kotlin.math.max

fun String.getMaxPalindrome() : String {
    data class Node(var ch: String, var length: Int)
    val word = this
    var result = ""
    val size = word.length
    val array = Array(size) { Array(size) { Node("", 0) } }
    for (i in array.indices) {
        array[i][i].ch = word[i].toString()
        array[i][i].length = 1
    }
    for (i in 1 until size) {
        for (j in i - 1 downTo 0) {
            array[i][j].ch = array[i - 1][j].ch + word[i]
            if (array[i][j].ch.first() == array[i][j].ch.last()) {
                array[i][j].length = array[i - 1][j + 1].length + 2
            } else {
                array[i][j].length = max(array[i - 1][j].length, array[i][j + 1].length)
            }
        }
    }
    if (array[size - 1][0].length > 0) {
        val palindrome = Array(size) { "" }
        var right = word.length - 1
        var left = 0
        var palLeft = 0
        var palRight = array[size - 1][0].length
        if (palRight == word.length) {
            palRight--
        }
        while (right >= left) {
            if (right == left && array[right][left].length == 1) {
                palindrome[palLeft++] = word[left++].toString()
            } else {
                if (word[right] == word[left]) {
                    palindrome[palLeft++] = word[left++].toString()
                    palindrome[palRight--] = word[right--].toString()
                } else {
                    if (array[right - 1][left].length < array[right][left + 1].length) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }
        for (ch in palindrome) {
            if (ch != "") {
                result += ch
            }
        }
    }
    return result
}

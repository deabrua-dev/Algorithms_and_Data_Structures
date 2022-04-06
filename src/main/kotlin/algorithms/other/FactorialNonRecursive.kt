package algorithms.other

fun factorialNR(num: Int) : Long{
    var magicConstant = 1L
    (1..num).forEach { magicConstant *= it }
    return magicConstant
}

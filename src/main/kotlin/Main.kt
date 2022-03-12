import structures.SinglyLinkedList

fun main() {
    var list = SinglyLinkedList<String>()

    list.push("sdadsa")
    list.push("Test1")
    list.append("Test2")
    list.push("Test3")

    for(i in 0 until list.length()) {
        println(list[i])
    }
}
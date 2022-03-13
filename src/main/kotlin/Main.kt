import structures.DoublyLinkedList

fun main() {
    val list = DoublyLinkedList<String>()

    list.append("Test0")
    list.append("Test1")
    list.append("Test2")
    list.append("Test3")
    list.append("Test4")
    list.append("Test5")
    list.append("Test6")
    list.insert(3,"Test2")
    println("Test get: " + list[6])
    list[6] = "Punk"
    println("Test set: " + list[6])
    list.remove(1)
    println(list.indexOf("Test2"))
    for(i in 0 until list.length()) {
        println(list[i])
    }
}
import structures.Queue

fun main() {
    val queue = Queue<String>()
    queue.push("Test0")
    queue.push("Test1")
    queue.push("Test2")
    queue.push("Test3")
    queue.push("Test4")

    while (queue.length() != 0) {
        println(queue.front())
        queue.pop()
    }
    println("Ready")
}
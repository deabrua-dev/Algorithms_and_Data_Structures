import structures.PriorityQueue

fun main() {
    val queue = PriorityQueue<String>()
    queue.push("Test0", 0)
    queue.push("Test1", 2)
    queue.push("Test2", 0)
    queue.push("Test3", 1)
    queue.push("Test4", 3)
    queue.push("Test5", 1)
    queue.push("Test6", 3)
    queue.push("Test7", 1)
    queue.push("Test8", 0)
    queue.push("Test9", 2)
    queue.push("Test10", 6)


    while (queue.length() != 0) {
        println(queue.front())
        queue.pop()
    }
    println("Ready")
}

package algorithms.graph

interface Graph {
    fun addEdge(source: Int, target: Int, weight: Int = 1)
    fun get(source: Int, target: Int) : Int
    fun set(source: Int, target: Int, weight: Int)
    fun size() : Int
}

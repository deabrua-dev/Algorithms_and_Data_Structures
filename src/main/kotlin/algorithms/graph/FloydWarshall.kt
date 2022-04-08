package algorithms.graph

class FloydWarshall(private val graph: Graph) {
    private val size = this.graph.size()
    private val vertexDistance = Array(this.size) { Int.MAX_VALUE }
    private val vertexParent = Array(size) { 0 }
    private val vertexVisit = Array(this.size) { false }
    private var source = 0

    fun start(source: Int = 0) {
        if (source < 0 && source >= this.size) throw IllegalArgumentException()
        this.source = source
        this.vertexDistance[this.source] = 0

        for (i in 0 until size) {
            println("Vertex: " + (i + 1) + " Distance: " + vertexDistance[i])
        }
    }

    fun getPath(target: Int) : ArrayList<Int> {
        val path = ArrayList<Int>()
        var current = target
        while (current != this.source) {
            path.add(current)
            current = this.vertexParent[current]
        }
        path.add(this.source)
        path.reverse()
        return path
    }

    fun getPathWeight(target: Int) = this.vertexDistance[target]
}

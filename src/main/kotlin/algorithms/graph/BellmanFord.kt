package algorithms.graph

class BellmanFord(private val graph: Graph) {
    private val size = this.graph.size()
    private val vertexDistance = Array(this.size) { Int.MAX_VALUE }
    private val vertexParent = Array(size) { -1 }
    private val vertexVisit = Array(this.size) { false }
    private var source = 0

    fun start(source: Int = 0) {
        if (source < 0 && source >= this.size) throw IllegalArgumentException()
        this.source = source
        this.vertexDistance[this.source] = 0
        for (k in 0 until this.size) {
            for (i in 0 until this.size) {
                for (j in 0 until this.size) {
                    if (
                        this.graph.get(i, j) != 0 &&
                        this.vertexDistance[i] < Int.MAX_VALUE &&
                        this.vertexDistance[j] > this.vertexDistance[i] + this.graph.get(i, j)
                    ) {
                        this.vertexDistance[j] = this.vertexDistance[i] + this.graph.get(i, j)
                        this.vertexParent[j] = i
                    }
                }
            }
        }
        for (k in 0 until this.size) {
            for (i in 0 until this.size) {
                for (j in 0 until this.size) {
                    if (
                        this.graph.get(i, j) != 0 &&
                        (this.vertexDistance[j] > this.vertexDistance[i] + this.graph.get(i, j) || this.vertexDistance[i] == Int.MIN_VALUE )
                    ) {
                        this.vertexDistance[j] = Int.MIN_VALUE
                        this.vertexParent[j] = -1
                    }
                }
            }
        }
        for (i in 0 until size) {
            println("Vertex: " + (i + 1) + " Distance: " + vertexDistance[i])
        }
    }

    fun getPath(target: Int) : ArrayList<Int> {
        val path = ArrayList<Int>()
        var current = target
        while (
            current != this.source &&
            this.vertexParent[current] != -1
        ) {
            path.add(current)
            current = this.vertexParent[current]
        }
        path.add(this.source)
        path.reverse()
        return path
    }

    fun getPathWeight(target: Int) = this.vertexDistance[target]
}

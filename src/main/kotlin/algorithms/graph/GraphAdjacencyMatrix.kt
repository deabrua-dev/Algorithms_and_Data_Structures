package algorithms.graph

class GraphAdjacencyMatrix(private val size: Int = 0) : Graph {
    private val matrix = Array(size) { IntArray(size) }
    private var oriented = true

    override fun addEdge(source: Int, target: Int, weight: Int) {
        if (source >= 0 && target >= 0) {
            if (this.oriented) {
                this.matrix[source][target] = weight
            } else {
                this.matrix[source][target] = weight
                this.matrix[target][source] = weight
            }
        } else {
            println("Vertex points error")
        }
    }

    override fun get(source: Int, target: Int) = if (source >= 0 && target >= 0) this.matrix[source][target] else 0
    override fun set(source: Int, target: Int, weight: Int) {
        if (source >= 0 && target >= 0) {
            if (this.oriented) {
                this.matrix[source][target] = weight
            } else {
                this.matrix[source][target] = weight
                this.matrix[target][source] = weight
            }
        } else {
            println("Vertex points error")
        }
    }

    override fun size(): Int = this.size

    fun setOriented(flag: Boolean) {
        this.oriented = flag
    }
}

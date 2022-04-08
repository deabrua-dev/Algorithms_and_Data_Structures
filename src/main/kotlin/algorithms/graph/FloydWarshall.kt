package algorithms.graph

class FloydWarshall(private val graph: Graph) {
    private val size = this.graph.size()
    private val vertexDistance = Array(this.size) { Array(size) { Int.MAX_VALUE } }
    private val vertexParent = Array(this.size) { Array(size) { -1 } }
    init {
        for (i in 0 until this.graph.size()) {
            for (j in 0 until this.graph.size()) {
                this.vertexDistance[i][j] = this.graph.get(i, j)
                if (this.graph.get(i, j) != 0) {
                    this.vertexParent[i][j] = j
                } else {
                    this.vertexDistance[i][j] = Int.MAX_VALUE
                    this.vertexDistance[i][i] = 0
                }
            }
        }
    }

    fun start() {
        for (k in 0 until this.size) {
            for (i in 0 until this.size) {
                for (j in 0 until this.size) {
                    if (
                        this.vertexDistance[i][k] != Int.MAX_VALUE &&
                        this.vertexDistance[k][j] != Int.MAX_VALUE &&
                        this.vertexDistance[i][j] > this.vertexDistance[i][k] + this.vertexDistance[k][j]
                    ) {
                        this.vertexDistance[i][j] = this.vertexDistance[i][k] + this.vertexDistance[k][j]
                        this.vertexParent[i][j] = this.vertexParent[i][k]
                    }
                }
            }
        }
    }

    fun getPath(source: Int = 0, target: Int) : ArrayList<Int> {
        val path = ArrayList<Int>()
        if (this.vertexParent[source][target] == -1) return path
        var current = source
        while (current != target) {
            path.add(current)
            current = this.vertexParent[current][target]
        }
        path.add(target)
        return path
    }

    fun getPathWeight(source: Int = 0, target: Int) = this.vertexDistance[source][target]
}

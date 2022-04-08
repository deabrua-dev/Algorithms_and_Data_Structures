package algorithms.graph

import structures.Queue

class BFS(private val graph: Graph) {
    private val size = graph.size()
    private val vertexVisit = Array(this.size) { false }
    private val vertexParent = Array(this.size) { 0 }
    private val inQueue = Array(this.size) { false }
    private var source = 0

    fun start(source: Int = 0) {
        val queue = Queue<Int>()
        queue.push(source)
        this.source = source

        this.inQueue[source] = true
        while (!queue.isEmpty()) {
            val i = queue.front()!!
            queue.pop()
            if (!this.vertexVisit[i]) {
                this.vertexVisit[i] = true
            }
            for (j in 0 until this.size) {
                if (!this.vertexVisit[j] && this.graph.get(i, j) != 0 && !this.inQueue[j]) {
                    queue.push(j)
                    inQueue[j] = true
                    this.vertexParent[j] = i
                }
            }
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
}

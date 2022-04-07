package algorithms.graph

import structures.Stack

class DFS(private val graph: Graph) {
    enum class VertexColor {
        WHITE,
        GRAY,
        BLACK
    }
    private val size = graph.size()
    private val vertexColor = Array(size) { VertexColor.WHITE }
    private val vertexParent = Array(size) { 0 }
    private var source = 0
    private var cycle = false

    fun start(source: Int = 0) {
        val stack = Stack<Int>()
        stack.push(source)
        this.source = source

        val timeIn = Array(size) { 0 }
        val timeOut = Array(size) { 0}
        var dfsTimer = 0

        while (!stack.isEmpty()) {
            val i = stack.top()!!
            if (this.vertexColor[i] == VertexColor.WHITE) {
                timeIn[i] = dfsTimer++
                for (j in this.size - 1 downTo 0) {
                    this.vertexColor[i] = VertexColor.GRAY
                    if (this.vertexColor[j] == VertexColor.WHITE && this.graph.get(i, j) != 0) {
                        stack.push(j)
                        this.vertexParent[j] = i
                    } else if (this.vertexColor[j] == VertexColor.GRAY && this.graph.get(i, j) != 0) {
                        this.cycle = true
                    }
                }
            } else if (this.vertexColor[i] == VertexColor.GRAY) {
                this.vertexColor[i] = VertexColor.BLACK
                timeOut[i] = dfsTimer++
            } else if (this.vertexColor[i] == VertexColor.BLACK) {
                stack.pop()
            }
        }
    }

    fun getWay(target: Int) : ArrayList<Int> {
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

package algorithms.other

import structures.PriorityQueue

class HuffmanCode(private var text: String) {
    private class Node(
        private var freq: Int = 0,
        private var ch: Char = ' ',
        private var left: Node? = null,
        private var right: Node? = null
    ) {
        fun freq() = this.freq
        fun char() = this.ch
        fun left() = this.left
        fun right() = this.right
    }
    private var codesTable = mutableMapOf<Char, String>()
    private var rootNode: Node? = null

    fun encode() : String {
        var code = ""
        this.createHuffTable()
        for (ch in text) {
            code += this.codesTable[ch]
        }
        return code
    }

    fun decode(code: String) : String {
        var realString = ""
        var index = 0
        while (index < code.length) {
            var currentNode = this.rootNode
            while (currentNode != null) {
                if (currentNode.left() == null && currentNode.right() == null) {
                    realString += currentNode.char()
                    break
                } else {
                    if (code[index] == '0') {
                        currentNode = currentNode.left()
                    } else {
                        currentNode = currentNode.right()
                    }
                    index++
                }
            }
        }
        return realString
    }

    private fun buildTree(node: Node?, code: String) {
        if (node == null) return
        if (node.left() == null && node.right() == null) {
            this.codesTable[node.char()] = code
        }
        this.buildTree(node.left(), code + "0")
        this.buildTree(node.right(), code + "1")
    }

    private fun createHuffTable() {
        val queue = this.createQueue()
        while (queue.length() > 1) {
            val left = queue.front()
            queue.pop()
            val right = queue.front()
            queue.pop()
            val sum = left!!.freq() + right!!.freq()
            queue.push(Node(sum, '@', left, right), sum)
        }
        this.setRoot(queue.front()!!)
        queue.pop()
        this.buildTree(this.rootNode, "")
    }

    private fun createQueue() : PriorityQueue<Node> {
        val queue = PriorityQueue<Node>()
        val charsAndFreq = mutableMapOf<Char, Int>()
        for (ch in this.text) {
            if (charsAndFreq.containsKey(ch)) {
                charsAndFreq[ch] = charsAndFreq[ch]!!.plus(1)
            } else {
                charsAndFreq[ch] = 1
            }
        }
        for (item in charsAndFreq) {
            queue.push(Node(item.value, item.key), item.value)
        }
        return queue
    }

    private fun setRoot(node: Node) {
        this.rootNode = node
    }
}

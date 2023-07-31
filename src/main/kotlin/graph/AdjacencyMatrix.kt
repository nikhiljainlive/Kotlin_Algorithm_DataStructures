package graph

/**
 * Reading graph vertex and edges in an adjacency list
 *
 * Graph -
 *
 *      0 --- 1
 *      |   / | \
 *      |  /  |  2
 *      | /   | /
 *      4 --- 3
 *
 * Adjacency List -
 *
 *         _ 0 _ 1 _ 2 _ 3 _ 4
 *      0 |  0   1   0   0   1
 *      1 |  1   0   1   1   1
 *      2 |  0   1   0   1   0
 *      3 |  0   1   1   0   1
 *      4 |  1   1   0   1   0
 * */
fun main() {
    executeHardCodedExample()
}

private fun executeHardCodedExample() {
    val vertices = 5
    val graph = AdjacencyMatrixGraph(vertices)
    graph.addEdge(0, 4)
    graph.addEdge(0, 1)
    graph.addEdge(1, 4)
    graph.addEdge(1, 3)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 4)
    println(graph)
}

private class AdjacencyMatrixGraph(private val vertices: Int) {
    private val adjacencyMatrix = Array<Array<Int>>(vertices) { Array(vertices) { 0 } }

    fun addEdge(vertex: Int, anotherVertex: Int) {
        adjacencyMatrix[vertex][anotherVertex] = 1
        adjacencyMatrix[anotherVertex][vertex] = 1
    }

    override fun toString(): String {
        return buildString {
            append("   ")
            (adjacencyMatrix.indices).forEach { append("$it  ") }
            append("\n")
            for (i in adjacencyMatrix.indices) {
                append("$i  ")
                for (j in 0 until adjacencyMatrix[0].size) {
                    append("${adjacencyMatrix[i][j]}  ")
                }
                append("\n")
            }
        }
    }
}
package graph

/**
 * Reading graph vertex and edges in an adjacency list
 *
 * Graph 1 & 2 -
 *
 *      0 --- 1
 *      |   / | \
 *      |  /  |  2
 *      | /   | /
 *      4 --- 3
 *
 *          1 --- 3
 *        / |     |
 *       0  |     |
 *        \ |     |
 *          2 --- 4
 *
 * Adjacency List -
 *
 * * 0 vertex -> 4 --> 1
 * * 1 vertex -> 0 --> 4 --> 3 --> 2
 * * 2 vertex -> 1 --> 3
 * * 3 vertex -> 1 --> 2 --> 4
 * * 4 vertex -> 0 --> 1 --> 3
 * */
fun main() {
    executeHardcodedExample()
    executeUserSelectedExample()
}

private fun executeHardcodedExample() {
    val vertices = 5
    println("Number of vertices: $vertices")

    val graph = AdjacencyListGraph(vertices)

//  Graph 1
    graph.addEdge(0, 4)
    graph.addEdge(0, 1)
    graph.addEdge(1, 4)
    graph.addEdge(1, 3)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 4)
    println(graph)

//    Graph 2
//    graph.addEdge(0, 1)
//    graph.addEdge(0, 2)
//    graph.addEdge(1, 2)
//    graph.addEdge(1, 3)
//    graph.addEdge(2, 4)
//    graph.addEdge(3, 4)
//    println(graph)

    // Depth First Search
    println("Depth First Search")
    graph.depthFirstTraversal(2)
    println()

    // Breadth First Search
    println("Breadth First Search")
    graph.breadthFirstTraversal(0)
}

private fun executeUserSelectedExample() {
    print("Number of vertices: ")
    val vertices = readLine()?.toIntOrNull() ?: run {
        println("Vertices can not be empty")
        return
    }

    val graph = AdjacencyListGraph(vertices)
    while (true) {
        print("Enter vertex 1 or enter q to finish: ")
        val userInput = readLine()
        if (userInput == "q") {
            break
        }
        val vertex1 = userInput?.toIntOrNull() ?: run {
            println("Vertex 1 can not be empty")
            return
        }
        print("Enter vertex 2 : ")
        val vertex2 = readLine()?.toIntOrNull() ?: run {
            println("Vertex 2 can not be empty")
            return
        }
        graph.addEdge(vertex1, vertex2)
    }
    print(graph)

    // Depth First Search
    println("Depth First Search")
    graph.depthFirstTraversal(2)
    println()

    // Breadth First Search
    println("Breadth First Search")
    graph.breadthFirstTraversal(0)
}

private class AdjacencyListGraph(private val vertices: Int) {
    private val adjacencyList = Array<MutableList<Int>>(vertices) { arrayListOf() }

    /**
     * add edge between two vertices
     * @param vertex vertex 1
     * @param anotherVertex vertex 2
     * */
    fun addEdge(vertex: Int, anotherVertex: Int) {
        adjacencyList[vertex] = adjacencyList.getOrNull(vertex).orEmpty().toMutableList().also { it.add(anotherVertex) }
        adjacencyList[anotherVertex] =
            adjacencyList.getOrNull(anotherVertex).orEmpty().toMutableList().also { it.add(vertex) }
    }

    fun depthFirstTraversal(start: Int, visitedArray: Array<Boolean> = Array(vertices) { false }) {
        visitedArray[start] = true
        println(start)
        adjacencyList[start].forEach {
            if (!visitedArray[it]) {
                depthFirstTraversal(it, visitedArray)
            }
        }
    }

    fun breadthFirstTraversal(
        start: Int,
        visitedArray: Array<Boolean> = Array(vertices) { false },
        queue: MutableList<Int> = mutableListOf()
    ) {
        queue.add(start)
        visitedArray[start] = true
        while (queue.isNotEmpty()) {
            val first = queue.removeFirstOrNull() ?: break
            println(first)
            adjacencyList[first].forEach {
                if (!visitedArray[it]) {
                    visitedArray[it] = true
                    queue.add(it)
                }
            }
        }
    }

    override fun toString(): String {
        return buildString {
            for ((index, element) in adjacencyList.withIndex()) {
                append("$index -> ${element.joinToString(" --> ")}")
                append("\n")
            }
        }
    }
}
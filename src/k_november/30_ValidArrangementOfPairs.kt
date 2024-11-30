package k_november

import kotlin.collections.set


/**
 *  Problem 30. Valid Arrangement of Pairs.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(V + E)
 *          - E edges
 *          - V vertices.
 *       - Space complexity: O(V + E)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(intArrayOf(5, 1), intArrayOf(4, 5), intArrayOf(11, 9), intArrayOf(9, 4))
    )

    testCases.forEach { pairs ->
        println("Result ==> ${validArrangement(pairs).map { it.toList() }}")
    }

}


fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
    val adjacencyMatrix = mutableMapOf<Int, ArrayDeque<Int>>()
    val inDegree = mutableMapOf<Int, Int>()
    val outDegree = mutableMapOf<Int, Int>()

    for (pair in pairs) {
        val start = pair[0]
        val end = pair[1]
        adjacencyMatrix.computeIfAbsent(start) { ArrayDeque() }.add(end)
        outDegree[start] = outDegree.getOrDefault(start, 0) + 1
        inDegree[end] = inDegree.getOrDefault(end, 0) + 1
    }

    val result = mutableListOf<Int>()

    var startNode = -1
    for (node in outDegree.keys) {
        if (outDegree[node] == inDegree.getOrDefault(node, 0) + 1) {
            startNode = node
            break
        }
    }

    if (startNode == -1) {
        startNode = pairs[0][0]
    }

    visit(startNode, adjacencyMatrix, result)
    result.reverse()
    return Array(result.size - 1) { i ->
        intArrayOf(result[i], result[i + 1])
    }
}

fun visit(node: Int, adjMatrix: MutableMap<Int, ArrayDeque<Int>>, res: MutableList<Int>) {
    val neighbors = adjMatrix[node]
    while (!neighbors.isNullOrEmpty()) {
        val nextNode = neighbors.removeFirst()
        visit(nextNode, adjMatrix, res)
    }
    res.add(node)
}
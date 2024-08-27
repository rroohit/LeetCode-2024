package h_august

import java.util.*

/**
 *  Problem 27. Path with Maximum Probability
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(E LogE)
 *
 *       - Space complexity: O(E + V)
 *
 * ## Code -
 */
fun main() {


}

fun maxProbability(
    n: Int,
    edges: Array<IntArray>,
    succProb: DoubleArray,
    startNode: Int,
    endNode: Int
): Double {
    val visited = mutableSetOf<Int>()
    val maxHeap = PriorityQueue<Edge>() { a, b -> if (a.weight < b.weight) 1 else -1 }
    val adjList = mutableMapOf<Int, MutableList<Edge>>()

    edges.forEachIndexed { index, it ->
        if (adjList.contains(it[0]).not()) adjList.put(it[0], mutableListOf<Edge>())
        adjList.get(it[0])!!.add(Edge(it[1], succProb[index]))
        if (adjList.contains(it[1]).not()) adjList.put(it[1], mutableListOf<Edge>())
        adjList.get(it[1])!!.add(Edge(it[0], succProb[index]))
    }

    adjList[startNode]?.forEach {
        maxHeap.add(it)
    }

    while (maxHeap.isNotEmpty()) {
        val max = maxHeap.poll()
        if (max.vertex == endNode) return max.weight
        visited.add(max.vertex)
        adjList[max.vertex]?.forEach {
            if (visited.contains(it.vertex).not()) {
                maxHeap.add(
                    Edge(it.vertex, it.weight * max.weight)
                )
            }
        }
    }
    return 0.0
}

private data class Edge(
    val vertex: Int,
    val weight: Double
)
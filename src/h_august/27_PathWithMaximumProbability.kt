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

    val result = maxProbability1(
        n = 3,
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 2)
        ),
        succProb = doubleArrayOf(0.5, 0.5, 0.2),
        startNode = 0,
        endNode = 0
    )

    println("Result => $result")

}

fun maxProbability1(
    n: Int,
    edges: Array<IntArray>,
    succProb: DoubleArray,
    startNode: Int,
    endNode: Int
): Double {
    val visited = mutableSetOf<Int>()
    val maxHeap = PriorityQueue<Edge1> { a, b -> if (a.weight < b.weight) 1 else -1 }
    val adjList = mutableMapOf<Int, MutableList<Edge1>>()

    edges.forEachIndexed { index, it ->
        if (adjList.contains(it[0]).not()) adjList[it[0]] = mutableListOf()
        adjList[it[0]]!!.add(Edge1(it[1], succProb[index]))
        if (adjList.contains(it[1]).not()) adjList[it[1]] = mutableListOf()
        adjList[it[1]]!!.add(Edge1(it[0], succProb[index]))
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
                    Edge1(it.vertex, it.weight * max.weight)
                )
            }
        }
    }
    return 0.0
}

private data class Edge1(
    val vertex: Int,
    val weight: Double
)
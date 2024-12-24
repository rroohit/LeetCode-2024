package l_december

import java.util.*
import kotlin.math.ceil
import kotlin.math.max


/**
 *  Problem 24. Find Minimum Diameter After Merging Two Trees.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3)),
            arrayOf(intArrayOf(0, 1))
        ),
        Pair(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(3, 6),
                intArrayOf(2, 7)
            ),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5),
                intArrayOf(3, 6),
                intArrayOf(2, 7)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumDiameterAfterMerge(test.first, test.second)}")
    }

}

fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
    // Calculate the number of nodes for each tree
    val n: Int = edges1.size + 1
    val m: Int = edges2.size + 1

    // Build adjacency lists for both trees
    val adjList1: List<List<Int>> = buildAdjList(n, edges1)
    val adjList2: List<List<Int>> = buildAdjList(m, edges2)

    // Calculate the diameters of both trees
    val diameter1 = findDiameter(n, adjList1)
    val diameter2 = findDiameter(m, adjList2)

    // Calculate the longest path that spans across both trees
    val combinedDiameter = ceil(diameter1 / 2.0).toInt() + ceil(diameter2 / 2.0).toInt() + 1

    return max(max(diameter1, diameter2), combinedDiameter)
}

private fun buildAdjList(size: Int, edges: Array<IntArray>): List<MutableList<Int>> {
    val adjList: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0..<size) {
        adjList.add(ArrayList())
    }
    for (edge in edges) {
        adjList[edge[0]].add(edge[1])
        adjList[edge[1]].add(edge[0])
    }
    return adjList
}

private fun findDiameter(n: Int, adjList: List<List<Int>>): Int {
    val firstBFS = findFarthestNode(n, adjList, 0)
    val farthestNode = firstBFS.first
    val secondBFS = findFarthestNode(n, adjList, farthestNode)
    return secondBFS.second
}

private fun findFarthestNode(
    n: Int,
    adjList: List<List<Int>>,
    sourceNode: Int
): PairT {
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(n)
    queue.add(sourceNode)
    visited[sourceNode] = true

    var maximumDistance = 0
    var farthestNode = sourceNode

    while (!queue.isEmpty()) {
        val size = queue.size
        for (i in 0..<size) {
            val currentNode = queue.poll()
            farthestNode = currentNode
            for (neighbor in adjList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                }
            }
        }
        if (!queue.isEmpty()) maximumDistance++
    }
    return PairT(farthestNode, maximumDistance)
}

class PairT(val first: Int, val second: Int)

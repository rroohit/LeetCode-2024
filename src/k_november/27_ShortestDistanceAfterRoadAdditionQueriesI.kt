package k_november

import kotlin.math.min


/**
 *  Problem 27. Shortest Distance After Road Addition Queries I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            5, arrayOf(
                intArrayOf(2, 4),
                intArrayOf(0, 2),
                intArrayOf(0, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${shortestDistanceAfterQueries(test.first, test.second).toList()}")

    }

}


fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val answer: MutableList<Int> = ArrayList()
    val adjList: MutableList<MutableList<Int>> = ArrayList()

    for (i in 0..<n) {
        adjList.add(ArrayList())
    }

    for (i in 0..<n - 1) {
        adjList[i].add(i + 1)
    }

    for (road in queries) {
        val u = road[0]
        val v = road[1]
        adjList[u].add(v)

        answer.add(findMinDistance(adjList, n))
    }

    val result = IntArray(answer.size)
    for (i in answer.indices) {
        result[i] = answer[i]
    }

    return result
}


fun findMinDistance(adjList: List<List<Int>>, n: Int): Int {
    val dp = IntArray(n)
    dp[n - 1] = 0

    for (currentNode in n - 2 downTo 0) {
        var minDistance = n
        for (neighbor in adjList[currentNode]) {
            minDistance = min(minDistance.toDouble(), (dp[neighbor] + 1).toDouble()).toInt()
        }
        dp[currentNode] = minDistance
    }

    return dp[0]
}













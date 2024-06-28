package f_june

import java.util.*

/**
 *  Problem 28. Maximum Total Importance of Roads
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            5,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumImportance(test.first, test.second)}")
    }

}

fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
    val connectedCities = LongArray(n)
    for ((n1, n2) in roads) {
        connectedCities[n1]++
        connectedCities[n2]++
    }

    val priorityQueue: PriorityQueue<Long> = PriorityQueue<Long>()
    for (connectedCity in connectedCities) {
        priorityQueue.add(connectedCity)
    }

    var maxImp = 0L
    var ind = 1
    while (priorityQueue.isNotEmpty()) {
        maxImp += (priorityQueue.poll() * ind++)
    }

    return maxImp
}

// TC - O(n logn) :: SC - O(n)
fun maximumImportance2(n: Int, roads: Array<IntArray>): Long {
    val connectedCities = LongArray(n)
    for ((n1, n2) in roads) {
        connectedCities[n1]++
        connectedCities[n2]++
    }
    connectedCities.sort()

    var maxImp = 0L
    for (i in 1..n) {
        maxImp += (connectedCities[i - 1]) * i
    }

    return maxImp
}
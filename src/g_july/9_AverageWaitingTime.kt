package g_july

import kotlin.math.max

/**
 *  Problem 9. Average Waiting Time
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf( // 5.0
            intArrayOf(1, 2),
            intArrayOf(2, 5),
            intArrayOf(4, 3)
        )
    )

    testCases.forEach { customers ->
        println("Result ==> ${averageWaitingTime(customers)}")
    }

}

fun averageWaitingTime(customers: Array<IntArray>): Double {
    var totalWaiting = 0.0
    var lastFinishingTime = 0
    for (customer in customers) {
        lastFinishingTime = customer[0] + customer[1] + max(lastFinishingTime - customer[0], 0)
        totalWaiting += lastFinishingTime - customer[0]
    }
    return totalWaiting / customers.size
}
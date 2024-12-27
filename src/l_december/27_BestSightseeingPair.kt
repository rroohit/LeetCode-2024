package l_december

import kotlin.math.max


/**
 *  Problem 27. Best Sightseeing Pair.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(8, 1, 5, 2, 6),
        intArrayOf(7, 2, 6, 6, 9, 4, 3),
        intArrayOf(1, 2)
    )

    testCases.forEach { values ->
        println("Result ==> ${maxScoreSightseeingPair(values)}")
    }


}

fun maxScoreSightseeingPair(values: IntArray): Int {
    val n: Int = values.size
    val maxLeftScore = IntArray(n)
    maxLeftScore[0] = values[0]

    var maxScore = 0
    for (i in 1..<n) {
        val currentRightScore = values[i] - i
        maxScore = max(
            maxScore,
            (maxLeftScore[i - 1] + currentRightScore)
        )

        val currentLeftScore = values[i] + i
        maxLeftScore[i] = max(maxLeftScore[i - 1], currentLeftScore)
    }

    return maxScore
}
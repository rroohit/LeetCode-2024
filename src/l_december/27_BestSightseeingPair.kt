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
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(8, 1, 5, 2, 6), // 11
        intArrayOf(7, 2, 6, 6, 9, 4, 3), // 14
        intArrayOf(1, 2), // 2
        intArrayOf(4, 7, 5, 8) //14
    )

    testCases.forEach { values ->
        println("Result ==> ${maxScoreSightseeingPair(values)}")
    }


}

// Dynamic Programming - Space optimized
// TC - O(n)
// SC - (1)
fun maxScoreSightseeingPair(values: IntArray): Int {
    var maxScore = -1
    var i = 0
    for (j in 1..<values.size) {
        val num = values[j]
        maxScore = max(maxScore, values[i] + num + i - j)
        if (num + j >= values[i] + i) i = j
    }
    return maxScore
}

// Dynamic Programming - Space optimized
// TC - O(n)
// SC - (1)
fun maxScoreSightseeingPair2(values: IntArray): Int {
    var maxScore = 0
    var left = values.first()
    for (j in 1..<values.size) {
        val right = values[j]
        maxScore = max(maxScore, left + right - j)
        if (right + j >= left) left = right + j
    }
    return maxScore
}

// Dynamic Programming
// TC - O(n)
// SC - (n)
fun maxScoreSightseeingPair1(values: IntArray): Int {
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
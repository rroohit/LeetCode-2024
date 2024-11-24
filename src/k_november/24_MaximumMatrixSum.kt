package k_november

import kotlin.math.abs
import kotlin.math.min

/**
 *  Problem 24. Maximum Matrix Sum.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(intArrayOf(1, -1), intArrayOf(-1, 1)),
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(-1, -2, -3),
            intArrayOf(1, 2, 3)
        )
    )

    testCases.forEach { matrix ->
        println("Result ==> ${maxMatrixSum(matrix)}")
    }

}

fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var totalSum = 0L
    var negCnt = 0
    var minAbs = Int.MAX_VALUE

    for (r in matrix.indices) {
        for (c in matrix[r].indices) {
            val num = matrix[r][c]
            totalSum += abs(num)
            if (num < 0) negCnt++
            minAbs = min(abs(num), minAbs)
        }
    }

    if (negCnt % 2 != 0) totalSum -= 2 * minAbs

    return totalSum
}
package h_august

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 20. Stone Game II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^3)
 *
 *       - Space complexity: O(N^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(2, 7, 9, 4, 4),
        intArrayOf(1, 2, 3, 4, 5, 100)
    )

    testCases.forEach { piles ->
        println("Result ==> ${stoneGameII(piles)}")
    }

}

fun stoneGameII(piles: IntArray): Int {
    val n = piles.size
    var suffixSum = 0
    val dp = Array(n + 1) { start -> IntArray(n - start + 1) }
    for (start in piles.indices.reversed()) {
        suffixSum += piles[start]
        for (m in 1..<dp[start].size) {
            for (x in 1..(m * 2)) {
                val nextStart = min(start + x, n)
                val nextM = min(n - nextStart, max(m, x))
                dp[start][m] = max(
                    dp[start][m], suffixSum - dp[nextStart][nextM]
                )
            }
        }
    }
    return dp[0][1]
}
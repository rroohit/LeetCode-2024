package d_april

import kotlin.math.abs
import kotlin.math.max

/**
 *  Problem 25. Longest Ideal Subsequence
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
        Pair(2, "acfgbd"),
        Pair(3, "abcd")
    )

    testCases.forEach { test ->
        val k = test.first
        val s = test.second

        println("Result ==> ${longestIdealString(s, k)}")
    }

}

fun longestIdealString(s: String, k: Int): Int {
    val dp = IntArray(26) { 0 }

    for (c in s) {
        val curr = c - 'a'
        var longs = 1
        for (prev in 0..<26) {
            if (abs(curr - prev) <= k) {
                longs = max(longs, 1 + dp[prev])
            }
        }
        dp[curr] = max(longs, dp[curr])
    }

    return dp.max()
}
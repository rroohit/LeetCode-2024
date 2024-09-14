package i_september

import kotlin.math.max

/**
 *  Problem 14. Longest Subarray With Maximum Bitwise AND
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 3, 2, 2),
        intArrayOf(1, 2, 3, 4)
    )

    testCases.forEach { test ->
        println("Result ==> ${longestSubarray(test)}")
    }

}

fun longestSubarray(nums: IntArray): Int {
    var maxVal = 0
    var ans = 0
    var currentStreak = 0

    for (num in nums) {
        if (maxVal < num) {
            maxVal = num
            currentStreak = 0
            ans = currentStreak
        }

        if (maxVal == num) {
            currentStreak++
        } else {
            currentStreak = 0
        }

        ans = max(ans.toDouble(), currentStreak.toDouble()).toInt()
    }
    return ans

}
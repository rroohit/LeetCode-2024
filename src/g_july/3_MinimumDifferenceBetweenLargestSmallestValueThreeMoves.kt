package g_july

import kotlin.math.min

/**
 *  Problem 3. Minimum Difference Between Largest and Smallest Value in Three Moves
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logN)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(5, 3, 2, 4),
        intArrayOf(1, 5, 0, 10, 14)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minDifference(nums)}")
    }

}

fun minDifference(nums: IntArray): Int {
    val n = nums.size - 1
    if (n <= 3) return 0

    nums.sort()
    var diff = Int.MAX_VALUE

    for (i in 0..<4) {
        val r = (n - 3) + i
        diff = min(diff, nums[r] - nums[i])
    }

    return diff
}
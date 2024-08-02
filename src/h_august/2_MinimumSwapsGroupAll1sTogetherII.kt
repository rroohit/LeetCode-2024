package h_august

import kotlin.math.min

/**
 *  Problem 2. Minimum Swaps to Group All 1's Together II
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
        intArrayOf(0, 1, 0, 1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 0),
        intArrayOf(1, 1, 0, 0, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minSwaps(nums)}")
    }

}

fun minSwaps(nums: IntArray): Int {
    val n = nums.size
    var l = 0
    var r = 0
    var windowOnes = 0
    val onesCount = nums.count { it == 1 }
    repeat(onesCount) {
        if (nums[r++] == 1) windowOnes++
    }

    var swaps = onesCount - windowOnes
    while (l < n) {
        swaps = min(swaps, (onesCount - windowOnes))
        r = (r  % n)
        if (nums[r++] == 1) windowOnes++
        if (nums[l++] == 1) windowOnes--
    }

    return swaps
}
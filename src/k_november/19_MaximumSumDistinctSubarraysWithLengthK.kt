package k_november

import kotlin.math.max

/**
 *  Problem 19. Maximum Sum of Distinct Subarrays With Length K.
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
        Pair(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3),
        Pair(intArrayOf(4, 4, 4), 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumSubarraySum(test.first, test.second)}")
    }

}

fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    val seen = HashSet<Int>()
    var maxSum = -1L

    var currSum = 0L
    var l = 0
    var r = 0

    while (r < nums.size) {
        val right = nums[r++]
        while (l <= r && seen.contains(right)) {
            val left = nums[l++]
            seen.remove(left)
            currSum -= left
        }
        seen.add(right)
        currSum += right

        if (r - l > k) {
            val left = nums[l++]
            seen.remove(left)
            currSum -= left
        }

        if (r - l == k) {
            maxSum = max(currSum, maxSum)
        }
    }

    return max(maxSum, 0L)
}
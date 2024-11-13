package k_november

import java.util.*


/**
 *  Problem 13. Count the Number of Fair Pairs.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logn)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(0, 1, 7, 4, 4, 5),
            Pair(3, 6)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countFairPairs(test.first, test.second.first, test.second.second)}")
    }

}

fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    Arrays.sort(nums)
    return lowerBound(nums, upper + 1) - lowerBound(nums, lower)
}

private fun lowerBound(nums: IntArray, value: Int): Long {
    var left = 0
    var right = nums.size - 1
    var result: Long = 0
    while (left < right) {
        val sum = nums[left] + nums[right]
        if (sum < value) {
            result += (right - left).toLong()
            left++
        } else {
            right--
        }
    }
    return result
}

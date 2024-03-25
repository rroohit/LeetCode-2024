package c_march

import kotlin.math.abs

/**
 *  Problem 25. Find all duplicates in array
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

    val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)

    val result = findDuplicates(nums)

    println("Result => $result")

}

fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    for (num in nums) {
        val n = abs(num)
        if (nums[n - 1] < 0) {
            result.add(n)
        }
        nums[n - 1] = -nums[n - 1]
    }
    return result
}





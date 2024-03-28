package c_march

import kotlin.math.max

/**
 *  Problem 28. Length of Longest Subarray With at Most K Frequency
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

    val nums = intArrayOf(1, 2, 3, 1, 2, 3, 1, 2)
    val k = 2

    println("Result ==> ${maxSubarrayLength(nums, k)}")

}

fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    var res = 0
    val freq = HashMap<Int, Int>()
    var l = 0 // left

    for ((r, num) in nums.withIndex()) {
        freq[num] = freq.getOrDefault(num, 0) + 1
        while (freq[num]!! > k) {
            freq[nums[l]] = freq[nums[l]]!! - 1
            l += 1
        }
        res = max(res, r - l + 1)
    }

    return res
}
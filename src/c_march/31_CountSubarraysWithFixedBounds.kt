package c_march

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 31. Count Subarrays With Fixed Bounds
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: o(1)
 *
 * ## Code -
 */
fun main() {

//    val nums = intArrayOf(1,3,5,2,7,5) // ans = 2 // min = 1, max = 5
    val nums = intArrayOf(1,1,1,1)
    val minK = 1
    val maxK = 1

    println("Result ==> ${countSubarrays(nums, minK, maxK)}")

}

// TC - O(n) : SC - O(1)
fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var ans = 0L
    var minI = -1
    var maxI = -1
    var badI = -1

    for (i in nums.indices) {
        val curr = nums[i]
        if(curr < minK || curr > maxK) badI = i
        if(curr == minK) minI = i
        if(curr == maxK) maxI = i
        ans += max(0, min(minI, maxI) - badI)
    }

    return ans
}
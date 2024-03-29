package c_march

/**
 *  Problem 29. Count Subarrays Where Max Element Appears at Least K Times
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

    val nums = intArrayOf(1, 3, 2, 3, 3)
    val k = 2

    println("Result ==> ${countSubarrays(nums, k)}")

}

fun countSubarrays(nums: IntArray, k: Int): Long {
    val n = nums.max()
    var mxCount = 0
    var l = 0
    var res = 0L

    for (r in nums.indices) {
        if (nums[r] == n) mxCount++
        while (mxCount == k) {
            if (nums[l] == n) {
                mxCount--
            }
            l++
        }
        res += l
    }

    return res
}
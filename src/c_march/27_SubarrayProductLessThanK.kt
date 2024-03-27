package c_march

/**
 *  Problem 27. Subarray Product Less Than K
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

    val nums = intArrayOf(10, 5, 2, 6)
    val k = 100

    println("Result ==> ${numSubarrayProductLessThanK(nums, k)}")

}

fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
    var res = 0
    var l = 0
    var prod = 1 // product

    for (r in nums.indices) {
        prod *= nums[r]
        while (l <= r && prod >= k) {
            prod /= nums[l]
            l++
        }
        res += (r - l) + 1
    }

    return res
}
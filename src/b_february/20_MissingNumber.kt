package b_february

/**
 *  Problem 20. Missing Number
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

    val nums = intArrayOf(9,6,4,2,3,5,7,0,1)

    println("Result ==> ${missingNumber(nums)}")

}

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    var res = (n * (n + 1)) / 2
    for(num in nums) {
        res -= num
    }
    return res
}
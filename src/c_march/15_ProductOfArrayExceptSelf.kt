package c_march

/**
 *  Problem 15. Product of Array Except Self
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

    val nums = intArrayOf(1, 2, 3, 4)

    val result = productExceptSelf(nums)

    println("Result => ${result.toList()}")

}

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size

    val ans = IntArray(n)
    ans[0] = 1

    for (i in 1..<n) {
        ans[i] = ans[i - 1] * nums[i - 1]
    }

    var suf = nums[n - 1]
    for (i in n - 2 downTo 0) {
        ans[i] = ans[i] * suf
        suf *= nums[i]
    }

    return ans
}
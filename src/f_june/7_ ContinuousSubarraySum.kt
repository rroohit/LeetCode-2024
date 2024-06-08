package f_june

/**
 *  Problem 7.  Continuous Subarray Sum
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
        Pair(intArrayOf(23, 2, 4, 6, 7), 6)
    )

    testCases.forEach { test ->
        println("Result ==> ${checkSubarraySum(test.first, test.second)}")
    }

}

fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()

    map[0] = -1
    var sum = 0

    for (i in nums.indices) {
        sum += nums[i]
        val mod = sum % k
        if (map.containsKey(mod)) {
            if (i - map[mod]!! >= 2) {
                return true
            }
        } else {
            map[mod] = i
        }
    }
    return false
}
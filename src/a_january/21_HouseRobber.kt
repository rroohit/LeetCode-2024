package a_january

import kotlin.math.max

/**
 *  Problem = 21 : House Robber
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(1)
 *
 * # Code =>
 */
fun main() {

    val nums = intArrayOf(2, 1, 1, 2)

    val result = rob(nums)

    println("Result ==> $result")

}

fun rob(nums: IntArray): Int {
    var rob1 = 0
    var rob2 = 0

    for (i in nums) {
        val temp = max(rob1 + i, rob2)
        rob1 = rob2
        rob2 = temp
    }
    return rob2
}

// Need to improve for problem like - [2,1,1,2] start ==>
fun rob1(nums: IntArray): Int {
    val left = robHouse(0, nums)
    val right = robHouse(1, nums)

    return max(left, right)
}

private fun robHouse(currInd: Int, nums: IntArray): Int {
    if (currInd >= nums.size) return 0

    val result = nums[currInd] + robHouse(currInd + 2, nums)

    return result
} // <== end
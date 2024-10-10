package j_october

import java.util.*
import kotlin.math.max

/**
 *  Problem 10. Maximum Width Ramp
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(6, 0, 8, 2, 1, 5),
        intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxWidthRamp(nums)}")
    }

}

fun maxWidthRamp(nums: IntArray): Int {
    val stack = Stack<Int>()
    var maxWid = 0
    for (j in nums.indices) {
        if (stack.isEmpty() || nums[stack.peek()] > nums[j]) {
            stack.push(j)
        }
    }

    for (i in nums.size - 1 downTo 0) {
        while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i]) {
            maxWid = max(maxWid, i - stack.pop()!!)
        }
    }
    return maxWid
}
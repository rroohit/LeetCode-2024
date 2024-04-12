package d_april

import kotlin.math.max

/**
 *  Problem 12. Trapping Rain Water
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

    val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)

    println("Result ==> ${trap(height)}")

}

fun trap(height: IntArray): Int {
    var l = 0
    var r = height.size - 1

    var leftMax = height[l]
    var rightMax = height[r]

    var totalWater = 0

    while (l < r) {
        if (leftMax < rightMax) {
            l++
            leftMax = max(leftMax, height[l])
            totalWater += leftMax - height[l]
        } else {
            r--
            rightMax = max(rightMax, height[r])
            totalWater += rightMax - height[r]
        }
    }

    return totalWater
}
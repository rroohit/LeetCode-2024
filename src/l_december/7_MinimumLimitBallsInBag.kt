package l_december

import kotlin.math.ceil

/**
 *  Problem 7. Minimum Limit of Balls in a Bag.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log k)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(9), 3
        ),
        Pair(
            intArrayOf(2, 4, 8, 2), 4
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumSize(test.first, test.second)}")
    }

}

fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    var left = 1
    var right = nums.max()

    while (left < right) {
        val middle = (left + right) / 2
        if (isPossible(middle, nums, maxOperations)) {
            right = middle
        } else {
            left = middle + 1
        }
    }

    return left
}


private fun isPossible(
    maxBallsInBag: Int,
    nums: IntArray,
    maxOperations: Int
): Boolean {
    var totalOperations = 0
    for (num in nums) {
        val operations = ceil(num / maxBallsInBag.toDouble()).toInt() - 1
        totalOperations += operations
        if (totalOperations > maxOperations) {
            return false
        }
    }
    return true
}






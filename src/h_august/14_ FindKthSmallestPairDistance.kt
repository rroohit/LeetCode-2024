package h_august

import kotlin.math.abs

/**
 *  Problem 14.  Find K-th Smallest Pair Distance
 *
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N ^ 2)
 *
 *       - Space complexity: O(maxNum)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 1),
            1
        ),
        Pair(
            intArrayOf(1, 1, 1),
            1
        ),
        Pair(
            intArrayOf(1, 6, 1),
            3
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${smallestDistancePair(test.first, test.second)}")
    }

}

fun smallestDistancePair(nums: IntArray, k: Int): Int {
    val maxNum = nums.max()
    val distanceBucket = IntArray(maxNum + 1)

    for (i in nums.indices) {
        for (j in i + 1..<nums.size) {
            distanceBucket[abs(nums[i] - nums[j])]++
        }
    }

    var kk = k
    for (d in 0..maxNum) {
        kk -= distanceBucket[d]
        if (kk <= 0) return d
    }

    return -1
}
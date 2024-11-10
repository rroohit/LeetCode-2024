package k_november

import kotlin.math.min

/**
 *  Problem 10. Shortest Subarray With OR at Least K II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * log(Max))
 *          - Max is the maximum integer value in the array nums.
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3),
            2
        ),
        Pair(
            intArrayOf(2, 1, 8),
            10
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumSubarrayLength(test.first, test.second)}")
    }

}

fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
    var minLength = Int.MAX_VALUE
    var windowStart = 0
    var windowEnd = 0
    val bitCounts = IntArray(32)

    while (windowEnd < nums.size) {
        updateBitCounts(bitCounts, nums[windowEnd], 1)

        while (windowStart <= windowEnd &&
            convertBitCountsToNumber(bitCounts) >= k
        ) {
            minLength = min(minLength.toDouble(), (windowEnd - windowStart + 1).toDouble()).toInt()

            updateBitCounts(bitCounts, nums[windowStart], -1)
            windowStart++
        }

        windowEnd++
    }

    return if (minLength == Int.MAX_VALUE) -1 else minLength
}

private fun updateBitCounts(bitCounts: IntArray, number: Int, delta: Int) {
    for (bitPosition in 0..31) {
        if (((number shr bitPosition) and 1) != 0) {
            bitCounts[bitPosition] += delta
        }
    }
}

private fun convertBitCountsToNumber(bitCounts: IntArray): Int {
    var result = 0
    for (bitPosition in 0..31) {
        if (bitCounts[bitPosition] != 0) {
            result = result or (1 shl bitPosition)
        }
    }
    return result
}
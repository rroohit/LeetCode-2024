package l_december

import java.util.*
import kotlin.math.max


/**
 *  Problem 11. Maximum Beauty of an Array After Applying Operation.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logn)
 *
 *       - Space complexity: O(s)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(4, 6, 1, 2), 2)
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumBeauty(test.first, test.second)}")
    }

}

fun maximumBeauty(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var maxBeauty = 0

    for (i in nums.indices) {
        val upperBound = findUpperBound(nums, nums[i] + 2 * k)
        maxBeauty = max(maxBeauty.toDouble(), (upperBound - i + 1).toDouble()).toInt()
    }
    return maxBeauty
}

private fun findUpperBound(arr: IntArray, `val`: Int): Int {
    var low = 0
    var high = arr.size - 1
    var result = 0

    while (low <= high) {
        val mid = low + (high - low) / 2
        if (arr[mid] <= `val`) {
            result = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return result
}


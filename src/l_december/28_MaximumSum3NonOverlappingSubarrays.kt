package l_december

import java.util.*
import kotlin.math.max


/**
 *  Problem 28. Maximum Sum of 3 Non-Overlapping Subarrays.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n * m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 2, 1, 2, 6, 7, 5, 1), 2),
        Pair(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1), 2)
    )

    testCases.forEach { test ->
        println("Result ==> ${maxSumOfThreeSubarrays(test.first, test.second).toList()}")
    }

}

fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
    val n: Int = nums.size - k + 1
    val sums = IntArray(n)
    var windowSum = 0
    for (i in 0..<k) {
        windowSum += nums[i]
    }
    sums[0] = windowSum

    for (i in k..<nums.size) {
        windowSum = windowSum - nums[i - k] + nums[i]
        sums[i - k + 1] = windowSum
    }

    val memo = Array(n) { IntArray(4) }
    for (row in memo) {
        Arrays.fill(row, -1)
    }
    val indices = ArrayList<Int>()

    dp(sums, k, 0, 3, memo)

    dfsGetIndices(sums, k, 0, 3, memo, indices)

    val result = IntArray(3)
    for (i in 0..2) {
        result[i] = indices[i]
    }

    return result
}

private fun dp(sums: IntArray, k: Int, idx: Int, rem: Int, memo: Array<IntArray>): Int {
    if (rem == 0) return 0
    if (idx >= sums.size) {
        return if (rem > 0) Int.MIN_VALUE else 0
    }

    if (memo[idx][rem] != -1) {
        return memo[idx][rem]
    }

    val withCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo)
    val skipCurrent = dp(sums, k, idx + 1, rem, memo)

    memo[idx][rem] = max(withCurrent.toDouble(), skipCurrent.toDouble()).toInt()
    return memo[idx][rem]
}

private fun dfsGetIndices(
    sums: IntArray,
    k: Int,
    idx: Int,
    rem: Int,
    memo: Array<IntArray>,
    indices: ArrayList<Int>
) {
    if (rem == 0) return
    if (idx >= sums.size) return

    val withCurrent = sums[idx] + dp(sums, k, idx + k, rem - 1, memo)
    val skipCurrent = dp(sums, k, idx + 1, rem, memo)

    // Choose path that gave optimal result in DP
    if (withCurrent >= skipCurrent) { // Take current subarray
        indices.add(idx)
        dfsGetIndices(sums, k, idx + k, rem - 1, memo, indices)
    } else { // Skip current subarray
        dfsGetIndices(sums, k, idx + 1, rem, memo, indices)
    }
}
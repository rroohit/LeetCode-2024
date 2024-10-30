package j_october

import kotlin.math.max
import kotlin.math.min


/**
 *  Problem 30. Minimum Number of Removals to Make Mountain Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 3, 1),
        intArrayOf(2, 1, 1, 5, 6, 2, 3, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minimumMountainRemovals(nums)}")
    }

}

fun minimumMountainRemovals(nums: IntArray): Int {
    val n = nums.size

    val lisLength = IntArray(n) { 1 }
    val ldsLength = IntArray(n) { 1 }

    for (i in 0..<n) {
        for (j in i - 1 downTo 0) {
            if (nums[i] > nums[j]) {
                lisLength[i] = max(lisLength[i].toDouble(), (lisLength[j] + 1).toDouble()).toInt()
            }
        }
    }

    for (i in n - 1 downTo 0) {
        for (j in i + 1..<n) {
            if (nums[i] > nums[j]) {
                ldsLength[i] = max(ldsLength[i].toDouble(), (ldsLength[j] + 1).toDouble()).toInt()
            }
        }
    }

    var minRemovals = Int.MAX_VALUE
    for (i in 0..<n) {
        if (lisLength[i] > 1 && ldsLength[i] > 1) {
            minRemovals = min(
                minRemovals,
                (n - lisLength[i] - ldsLength[i] + 1)
            )
        }
    }

    return minRemovals
}
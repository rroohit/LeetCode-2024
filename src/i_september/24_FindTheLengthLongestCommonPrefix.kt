package i_september

import kotlin.math.log10
import kotlin.math.max

/**
 *  Problem 24. Find the Length of the Longest Common Prefix
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * log10M + n * log10N)
 *
 *       - Space complexity: O(m * log10M)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 10, 100),
            intArrayOf(1000)
        ),
        Pair(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 4, 4)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${longestCommonPrefix(test.first, test.second)}")
    }

}

fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val set = HashSet<Int>()
    for (num in arr1) {
        var n = num
        while (!set.contains(n) && n > 0) {
            set.add(n)
            n /= 10
        }
    }

    var longestPrefix = 0

    for (num in arr2) {
        var n = num
        while (!set.contains(n) && n > 0) {
            n /= 10
        }
        if (n > 0) {
            // Length of the matched prefix using log10 to determine the number of digits
            longestPrefix = max(
                longestPrefix.toDouble(),
                (log10(n.toDouble()).toInt() + 1).toDouble()
            ).toInt()
        }
    }

    return longestPrefix
}
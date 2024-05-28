package e_may

import kotlin.math.abs
import kotlin.math.max

/**
 *  Problem 28. Get Equal Substrings Within Budget
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

    val s = "abcd"
    val t = "bcdf"
    val maxCost = 3

    println("Result ==> ${equalSubstring(s, t, maxCost)}")

}

fun equalSubstring(s: String, t: String, maxCost: Int): Int {
    var maxLen = 0
    var currSum = 0
    var left = 0

    for (right in s.indices) {
        currSum += abs(s[right] - t[right])

        while (currSum > maxCost) {
            currSum -= abs(s[left] - t[left++])
        }

        maxLen = max(maxLen, (right - left) + 1)
    }

    return maxLen
}
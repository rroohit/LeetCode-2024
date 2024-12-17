package l_december

import kotlin.math.min

/**
 *  Problem 17. Construct String With Repeat Limit.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * K)
 *
 *       - Space complexity: O(K)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("cczazcc", 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${repeatLimitedString(test.first, test.second)}")
    }

}

fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val freq = IntArray(26)
    for (ch in s.toCharArray()) {
        freq[ch.code - 'a'.code]++
    }

    val result = StringBuilder()
    var currentCharIndex = 25
    while (currentCharIndex >= 0) {

        if (freq[currentCharIndex] == 0) {
            currentCharIndex--
            continue
        }

        val use = min(freq[currentCharIndex], repeatLimit)
        for (k in 0..<use) {
            result.append(('a'.code + currentCharIndex).toChar())
        }
        freq[currentCharIndex] -= use

        if (freq[currentCharIndex] > 0) {
            var smallerCharIndex = currentCharIndex - 1
            while (smallerCharIndex >= 0 && freq[smallerCharIndex] == 0) smallerCharIndex--
            if (smallerCharIndex < 0) break
            result.append(('a'.code + smallerCharIndex).toChar())
            freq[smallerCharIndex]--
        }
    }

    return result.toString()
}
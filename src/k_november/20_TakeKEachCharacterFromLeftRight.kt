package k_november

import kotlin.math.max


/**
 *  Problem 20. Take K of Each Character From Left and Right.
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

    val testCases = listOf(
        Pair("aabaaaacaabc", 2),
        Pair("a", 1)
    )

    testCases.forEach { test ->
        println("Result ==> ${takeCharacters(test.first, test.second)}")
    }


}
fun takeCharacters(s: String, k: Int): Int {
    val count = IntArray(3)
    val n = s.length

    for (c in s.toCharArray()) {
        count[c.code - 'a'.code]++
    }

    for (i in 0..2) {
        if (count[i] < k) return -1
    }

    val window = IntArray(3)
    var left = 0
    var maxWindow = 0

    for (right in 0..<n) {
        window[s[right].code - 'a'.code]++

        while (left <= right &&
            (count[0] - window[0] < k || count[1] - window[1] < k || count[2] - window[2] < k)
        ) {
            window[s[left].code - 'a'.code]--
            left++
        }

        maxWindow = max(maxWindow.toDouble(), (right - left + 1).toDouble()).toInt()
    }

    return n - maxWindow
}
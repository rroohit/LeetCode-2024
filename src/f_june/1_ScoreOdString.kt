package f_june

import kotlin.math.abs

/**
 *  Problem 1. Score of a String
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
        "hello",
        "zaz"
    )

    testCases.forEach { s ->
        println("Result ==> ${scoreOfString(s)}")
    }

}

fun scoreOfString(s: String): Int {
    var score = 0
    for (i in 0 ..< s.length - 1) {
        score += abs(s[i] - s[i + 1])
    }
    return score
}
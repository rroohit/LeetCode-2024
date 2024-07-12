package g_july

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 12. Maximum Score From Removing Substrings
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple("cdbcbbaaabab", 4, 5)
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumGain(test.first, test.second, test.third)}")
    }

}

fun maximumGain(s: String, x: Int, y: Int): Int {
    var maxScore = 0
    val key = if (x > y) "ab" else "ba"
    val roundOne = removePairs(s, key, max(x, y))
    maxScore += roundOne.second
    val roundTwo = removePairs(roundOne.first, key.reversed(), min(x, y))
    return maxScore + roundTwo.second
}

private fun removePairs(s: String, key: String, keyScore: Int): Pair<String, Int> {
    val stack = Stack<Char>()
    var score = 0
    for (ch in s) {
        val last = stack.lastOrNull()
        val curKey = "$last$ch"
        if (curKey == key) {
            score += keyScore
            stack.pop()
        } else {
            stack.push(ch)
        }
    }
    return Pair(stack.joinToString(""), score)
}
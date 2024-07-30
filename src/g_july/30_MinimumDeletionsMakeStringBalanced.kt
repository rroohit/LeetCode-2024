package g_july

import kotlin.math.min

/**
 *  Problem 30. Minimum Deletions to Make String Balanced
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "aababbab",
        "bbaaaaabb"
    )

    testCases.forEach { str ->
        println("Result ==> ${minimumDeletions(str)}")
    }

}

fun minimumDeletions(s: String): Int {
    var aCount = 0
    for (i in s) {
        if (i == 'a') aCount++
    }

    var bCount = 0
    var totalDelete = s.length
    for (c in s) {
        if (c == 'a') aCount--
        totalDelete = min(totalDelete, aCount + bCount)
        if (c == 'b') bCount++
    }

    return totalDelete
}

fun minimumDeletions1(s: String): Int {
    val aCount = IntArray(s.length)
    for (i in s.length - 2 downTo 0) {
        aCount[i] = aCount[i + 1]
        aCount[i] += if (s[i + 1] == 'a') 1 else 0
    }

    var bCount = 0
    var totalDelete = s.length
    for ((i,c) in s.withIndex()) {
        totalDelete = min(totalDelete, aCount[i] + bCount)
        if (c == 'b') bCount++
    }

    return totalDelete
}
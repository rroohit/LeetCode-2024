package j_october

import kotlin.math.max

/**
 *  Problem 21. Split a String Into the Max Number of Unique Substrings
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * 2^n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "ababccc",
        "aba",
        "aa"
    )

    testCases.forEach { str ->
        println("Result ==> ${maxUniqueSplit(str)}")
    }

}

fun maxUniqueSplit(s: String): Int {
    val seen = HashSet<String>()
    val maxCount = IntArray(1)
    backtrackB(s, 0, seen, 0, maxCount)
    return maxCount.first()
}

private fun backtrackB(
    s: String,
    start: Int,
    seen: HashSet<String>,
    currCount: Int,
    maxCount: IntArray
) {
    if ((currCount + (s.length - start)) <= maxCount[0]) return
    if (start == s.length) {
        maxCount[0] = max(currCount, maxCount[0])
        return
    }

    for (end in start + 1..s.length) {
        val subStr = s.substring(start, end)
        if (!seen.contains(subStr)) {
            seen.add(subStr)
            backtrackB(s, end, seen, currCount + 1, maxCount)
            seen.remove(subStr)
        }
    }
    return
}

private fun backtrackA(s: String, start: Int, seen: HashSet<String>): Int {
    if (start == s.length) return 0 // base case
    var maxCount = 0
    for (end in start + 1..s.length) {
        val subStr = s.substring(start, end)
        if (!seen.contains(subStr)) {
            seen.add(subStr)
            maxCount = max(
                maxCount,
                1 + backtrackA(s, end, seen)
            )
            seen.remove(subStr)
        }
    }
    return maxCount
}
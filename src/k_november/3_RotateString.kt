package k_november

/**
 *  Problem 3. Rotate String.
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
        Pair("abcde", "cdeab"),
        Pair("abcde", "abced")
    )

    testCases.forEach { test ->
        println("Result ==> ${rotateString(test.first, test.second)}")
    }

}


fun rotateString(s: String, goal: String): Boolean {
    if (!s.isMatchingLength(goal)) return false
    if (s == goal) return true
    return (s + s).contains(goal)
}

private fun String.isMatchingLength(toStr: String): Boolean = (length == toStr.length)

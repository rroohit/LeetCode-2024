package f_june

/**
 *  Problem 3. Append Characters to String to Make Subsequence
 *
 *  ## Intuition -
 *
 *  ## Approach - Two Pointers
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCase = listOf(
        Pair("coaching", "coding"),
        Pair("abcde", "a"),
        Pair("z", "abcde")
    )

    testCase.forEach { test ->
        println("Result ==> ${appendCharacters(test.first, test.second)}")
    }

}

fun appendCharacters(s: String, t: String): Int {
    var ti = 0
    for (ch in s) {
        if (ch == t[ti]) ti++
        if (ti == t.length) return 0
    }
    return (t.length - ti)
}
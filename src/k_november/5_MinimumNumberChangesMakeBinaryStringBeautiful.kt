package k_november

/**
 *  Problem 5. Minimum Number of Changes to Make Binary String Beautiful.
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
        "1001",
        "10",
        "0000",
        "11"
    )


    testCases.forEach { s ->
        println("Result ==> ${minChanges(s)}")
    }

}

fun minChanges(s: String): Int {
    var count = 0
    for (i in s.indices step 2) {
        if (s[i] != s[i + 1]) count++
    }
    return count
}
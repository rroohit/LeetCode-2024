package i_september

/**
 *  Problem 12. Count the Number of Consistent Strings
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "ab",
            arrayOf("ad", "bd", "aaab", "baa", "badab")
        ),
        Pair(
            "abc",
            arrayOf("a", "b", "c", "ab", "ac", "bc", "abc")
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countConsistentStrings(test.first, test.second)}")
    }

}

fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    val charSet = HashSet<Char>()
    allowed.forEach { charSet.add(it) }

    var count = 0
    for (word in words) {
        var consistent = true
        for (ch in word) {
            if (!charSet.contains(ch)) {
                consistent = false
                break
            }
        }
        if (consistent) count++
    }
    return count
}
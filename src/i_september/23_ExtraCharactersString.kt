package i_september

/**
 *  Problem 23. Extra Characters in a String
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^3)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("leetscode", arrayOf("leet", "code", "leetcode"))
    )

    testCases.forEach { test ->
        println("Result ==> ${minExtraChar(test.first, test.second)}")
    }

}

fun minExtraChar(s: String, dictionary: Array<String>): Int {
    val n = s.length
    val dp = IntArray(n + 1)

    val set = dictionary.toSet()

    for ((i, c) in s.withIndex()) {
        dp[i + 1] = dp[i] + 1

        for (j in 0..i) {

            if (set.contains(s.substring(j, i + 1))) {

                dp[i + 1] = minOf(dp[i + 1], dp[j])

            }
        }
    }

    return dp.last()
}
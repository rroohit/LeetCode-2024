package h_august

/**
 *  Problem 21.  Strange Printer
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "aaabbb",
        "aba"
    )

    testCases.forEach { s ->
        println("Result ==> ${strangePrinter(s)}")
    }

}

fun strangePrinter(s: String): Int {
    val n = s.length
    val dp = Array(n) { IntArray(n) }
    for (i in n - 1 downTo 0) {
        dp[i][i] = 1
        for (j in i + 1..<n) {
            dp[i][j] = dp[i][j - 1] + 1
            for (k in i..<j) {
                if (s[k] == s[j]) dp[i][j] =
                    dp[i][j].coerceAtMost(dp[i][k] + if (k + 1 <= j - 1) dp[k + 1][j - 1] else 0)
            }
        }
    }
    return dp[0][n - 1]
}
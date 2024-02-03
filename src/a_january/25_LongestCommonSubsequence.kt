package a_january

/**
 *  Problem = 25 : Longest Common Subsequence
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O()
 *
 *      - Space complexity: O()
 *
 * # Code =>
 */
fun main() {

    val text1 = "abcde"
    val text2 = "ace"

    val result = longestCommonSubsequence(text1, text2)

    println("Result ==> $result")
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

    for (i in text1.length - 1 downTo 0) {
        for (j in text2.length - 1 downTo 0) {
            if (text1[i] == text2[j]) {
                dp[i][j] = 1 + dp[i + 1][j + 1]
            } else {
                dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    return dp[0][0]
}
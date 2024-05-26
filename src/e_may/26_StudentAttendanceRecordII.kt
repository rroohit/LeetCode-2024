package e_may

/**
 *  Problem 26. Student Attendance Record II
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

    val testCases = listOf(2, 1, 10101)

    testCases.forEach { n ->
        println("Result ==> ${checkRecord(n)}")
    }

}

const val MOD = 1_000_000_007L
fun checkRecord(n: Int): Int {
    var dp = longArrayOf(1L, 1L, 0L, 1L, 0L, 0L, 0L)

    for (i in 1..<n) {
        val dpNew = LongArray(7) {0L}

        dpNew[0] = (dp[0] + dp[1] + dp[2]) % MOD
        dpNew[1] = dp[0]
        dpNew[2] = dp[1]
        dpNew[3] = dpNew[0]
        dpNew[4] = (dp[3] + dp[4] + dp[5] + dp[6]) % MOD
        dpNew[5] = (dp[3] + dp[4]) % MOD
        dpNew[6] = dp[5]
        dp = dpNew
    }

    return (dp.sum() % MOD).toInt()
}
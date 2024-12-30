package l_december

/**
 *  Problem 30. Count Ways To Build Good Strings.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(high)
 *
 *       - Space complexity: O(high)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        TestData30(3, 3, 1, 1),
        TestData30(2, 3, 1, 2),
    )

    testCases.forEach { test ->
        println("Result ==> ${countGoodStrings(test.low, test.high, test.zero, test.one)}")
    }

}

// Dynamic Programming Iterative.
// TC - O(high)
// SC - O(high)
fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
    val dp = IntArray(high + 1) { 0 }
    dp[0] = 1
    val mod = 1000000007

    for (end in 1..high) {
        if (end >= zero) {
            dp[end] += dp[end - zero]
        }

        if (end >= one) {
            dp[end] += dp[end - one]
        }

        dp[end] %= mod
    }

    var ans = 0
    for (i in low..high) {
        ans += dp[i]
        ans %= mod
    }

    return ans
}

data class TestData30(
    val low: Int,
    val high: Int,
    val zero: Int,
    val one: Int
)
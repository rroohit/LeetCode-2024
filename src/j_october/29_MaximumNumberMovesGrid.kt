package j_october

import kotlin.math.max

/**
 *  Problem 29. Maximum Number of Moves in a Grid
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(2, 4, 3, 5),
            intArrayOf(5, 4, 9, 3),
            intArrayOf(3, 4, 2, 11),
            intArrayOf(10, 9, 13, 15)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${maxMoves(grid)}")
    }

}

// Bottom Up
fun maxMoves(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) { 0 } }
    for (j in n - 2 downTo 0) {
        for (i in 0..<m) {
            var ne = 0
            if (i > 0 && grid[i - 1][j + 1] > grid[i][j]) ne = 1 + dp[i - 1][j + 1]
            var e = 0
            if (grid[i][j + 1] > grid[i][j]) e = 1 + dp[i][j + 1]
            var se = 0
            if (i < m - 1 && grid[i + 1][j + 1] > grid[i][j]) se = 1 + dp[i + 1][j + 1]
            dp[i][j] = max(ne, max(e, se));
        }
    }
    var result = Int.MIN_VALUE
    for (i in 0..<m) {
        result = max(result, dp[i][0])
    }

    return result
}
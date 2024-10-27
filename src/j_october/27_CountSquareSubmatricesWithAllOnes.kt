package j_october

import java.util.*
import kotlin.math.min


/**
 *  Problem 27. Count Square Submatrices with All Ones.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(row * col)
 *
 *       - Space complexity: O(row * col)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )
    )

    testCases.forEach { matrix ->
        println("Result ==> ${countSquares(matrix)}")
    }

}

fun countSquares(matrix: Array<IntArray>): Int {
    var ans = 0
    val dp = Array(matrix.size) { IntArray(matrix[0].size) { -1 } }
    for (i in matrix.indices) {
        for (j in 0..<matrix[0].size) {
            Arrays.fill(dp[i], -1)
        }
    }
    for (i in matrix.indices) {
        for (j in 0..<matrix[0].size) {
            ans += solve(i, j, matrix, dp)
        }
    }

    return ans
}

fun solve(i: Int, j: Int, grid: Array<IntArray>, dp: Array<IntArray>): Int {
    if (i >= grid.size || j >= grid[0].size) return 0
    if (grid[i][j] == 0) return 0

    if (dp[i][j] != -1) return dp[i][j]

    val right = solve(i, j + 1, grid, dp)
    val diagonal = solve(i + 1, j + 1, grid, dp)
    val below = solve(i + 1, j, grid, dp)
    return (1 + min(right.toDouble(), min(diagonal.toDouble(), below.toDouble()))).also {
        dp[i][j] =
            it.toInt()
    }.toInt()
}
package e_may

import kotlin.math.max

/**
 *  Problem 14. Path with Maximum Gold
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 0, 7),
            intArrayOf(2, 0, 6),
            intArrayOf(3, 4, 5),
            intArrayOf(0, 3, 0),
            intArrayOf(9, 0, 20)
        ) // ans = 28
    )

    testCases.forEach { grid ->
        println("Result ==> ${getMaximumGold(grid)}")
    }


}

fun getMaximumGold(grid: Array<IntArray>): Int {
    var maxGold = 0

    for (r in grid.indices) { // Row
        for (c in grid[0].indices) { // Column
            if (grid[r][c] > 0) {
                maxGold = max(maxGold, miningGoldDfs(r, c, grid))
            }
        }
    }

    return maxGold
}

fun miningGoldDfs(r: Int, c: Int, grid: Array<IntArray>): Int {
    if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size || grid[r][c] <= 0) return 0
    val currCellGold = grid[r][c]
    grid[r][c] = -1

    val totalGold = currCellGold + maxOf(
        miningGoldDfs(r, c - 1, grid), // Left
        miningGoldDfs(r, c + 1, grid), // Right
        miningGoldDfs(r - 1, c, grid), // Up
        miningGoldDfs(r + 1, c, grid)  // Bottom
    ) // mining nearby cells

    grid[r][c] = currCellGold // Backtracking
    return totalGold
}











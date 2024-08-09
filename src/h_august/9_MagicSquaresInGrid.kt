package h_august

/**
 *  Problem 9. Magic Squares In Grid
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(R * C)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(4, 3, 8, 4),
            intArrayOf(9, 5, 1, 9),
            intArrayOf(2, 7, 6, 2)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${numMagicSquaresInside(grid)}")
    }

}

fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    val rowSize = grid.size
    val colSize = grid[0].size

    var magicCount = 0
    for (r in 0..rowSize - 3) {
        for (c in 0..colSize - 3) {
            if (isMagicCell(r, c, grid)) magicCount++
        }
    }

    return magicCount
}

private fun isMagicCell(r: Int, c: Int, grid: Array<IntArray>): Boolean {
    val seen = HashSet<Int>()
    // Check all nums are unique
    for (r1 in r..r + 2) {
        for (c1 in c..c + 2) {
            val num = grid[r1][c1]
            if (num !in 1..9 || seen.contains(num)) return false
            seen.add(num)
        }
    }

    // check all rows sum to 15
    for (r1 in r..r + 2) if (grid[r1][c] + grid[r1][c + 1] + grid[r1][c + 2] != 15) return false

    // check all cols sum to 15
    for (c1 in c..c + 2) if (grid[r][c1] + grid[r + 1][c1] + grid[r + 2][c1] != 15) return false

    // two diagonals sum to 15
    val diagonal1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]
    val diagonal2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]
    if (diagonal1 != diagonal2) return false

    return diagonal1 == 15
}















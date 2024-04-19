package d_april

/**
 *  Problem 19. Number of Islands
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
        arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
    )

    testCases.forEach { grid ->
        println("Result no Of Islands => ${numIslands(grid)}")
    }

}

fun numIslands(grid: Array<CharArray>): Int {
    var noOfIslands = 0
    for (r in grid.indices) { // Row
        for (c in grid[0].indices) { // Column
            if (grid[r][c] == '1') {
                dfsExploreNeiLands(r, c, grid)
                noOfIslands++
            }
        }
    }
    return noOfIslands
}

private fun dfsExploreNeiLands(r: Int, c: Int, grid: Array<CharArray>) {
    if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size || grid[r][c] == '0') return
    grid[r][c] = '0'
    dfsExploreNeiLands(r, c - 1, grid) // Left
    dfsExploreNeiLands(r, c + 1, grid) // Right
    dfsExploreNeiLands(r - 1, c, grid) // Up
    dfsExploreNeiLands(r + 1, c, grid) // Down
}
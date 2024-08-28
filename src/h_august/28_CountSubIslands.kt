package h_august

import java.util.*

/**
 *  Problem 28. Count Sub Islands
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
        Pair(
            arrayOf(
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 1, 1, 1, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(1, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 1, 1)
            ),
            arrayOf(
                intArrayOf(1, 1, 1, 0, 0),
                intArrayOf(0, 0, 1, 1, 1),
                intArrayOf(0, 1, 0, 0, 0),
                intArrayOf(1, 0, 1, 1, 0),
                intArrayOf(0, 1, 0, 1, 0)
            )
        ),
        Pair(
            arrayOf(
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(1, 0, 1, 0, 1)
            ),
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(1, 0, 0, 0, 1)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countSubIslands(test.first, test.second)}")
    }

}

fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    val visitedCell = Array(grid1.size) { BooleanArray(grid1[0].size) }
    var noOfIsland = 0

    for (r in grid2.indices) { // row traversal
        for (c in grid2[0].indices) { // column traversal
            if (!isCellLand(r, c, grid2) || visitedCell[r][c]) continue
            if (exploreAllLands(r, c, grid1, grid2, visitedCell)) noOfIsland++
        }
    }

    return noOfIsland
}

private fun exploreAllLands(
    currRow: Int,
    currCol: Int,
    grid1: Array<IntArray>,
    grid2: Array<IntArray>,
    visitedCells: Array<BooleanArray>
): Boolean {
    var isValidSubIsland = true
    val queue = LinkedList<Pair<Int, Int>>()
    queue.push(Pair(currRow, currCol))
    visitedCells[currRow][currCol] = true

    while (queue.isNotEmpty()) {
        val (r, c) = queue.poll() ?: continue
        if (!isCellLand(r, c, grid1)) isValidSubIsland = false
        listOf(
            Pair(0, -1),    // left
            Pair(0, 1),     // right
            Pair(-1, 0),    // Up
            Pair(1, 0)      // down
        ).forEach { cell ->
            val nextRow = cell.first + r
            val nextCol = cell.second + c
            if (nextRow in grid1.indices &&
                nextCol in grid1[0].indices &&
                !visitedCells[nextRow][nextCol] &&
                isCellLand(nextRow, nextCol, grid2)
            ) {
                visitedCells[nextRow][nextCol] = true
                queue.offer(Pair(nextRow, nextCol))
            }
        }
    }

    return isValidSubIsland
}

private fun isCellLand(r: Int, c: Int, grid: Array<IntArray>): Boolean = grid[r][c] == 1

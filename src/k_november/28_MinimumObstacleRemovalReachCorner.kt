package k_november

import java.util.*


/**
 *  Problem 28. Minimum Obstacle Removal to Reach Corner.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * nlog(m * n))
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${minimumObstacles(grid)}")
    }

}

private val directions = arrayOf(
    intArrayOf(0, 1),
    intArrayOf(0, -1),
    intArrayOf(1, 0),
    intArrayOf(-1, 0),
)

fun minimumObstacles(grid: Array<IntArray>): Int {
    val m: Int = grid.size
    val n: Int = grid[0].size

    val minObstacles = Array(m) { IntArray(n) { Int.MAX_VALUE } }

    // Start from the top-left corner, accounting for its obstacle value
    minObstacles[0][0] = grid[0][0]

    val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0] - b[0] }

    // Add the starting cell to the priority queue
    pq.add(intArrayOf(minObstacles[0][0], 0, 0))

    while (!pq.isEmpty()) {
        // Process the cell with the fewest obstacles removed so far
        val current = pq.poll()
        val obstacles = current[0]
        val row = current[1]
        val col = current[2]

        // If we've reached the bottom-right corner, return the result
        if (row == m - 1 && col == n - 1) {
            return obstacles
        }

        // Explore all four possible directions from the current cell
        for (dir in directions) {
            val newRow = row + dir[0]
            val newCol = col + dir[1]

            if (isValidCell(grid, newRow, newCol)) {
                // Calculate the obstacles removed if moving to the new cell
                val newObstacles = obstacles + grid[newRow][newCol]

                // Update if we've found a path with fewer obstacles to the new cell
                if (newObstacles < minObstacles[newRow][newCol]) {
                    minObstacles[newRow][newCol] = newObstacles
                    pq.add(intArrayOf(newObstacles, newRow, newCol))
                }
            }
        }
    }

    return minObstacles[m - 1][n - 1]
}

private fun isValidCell(grid: Array<IntArray>, row: Int, col: Int): Boolean {
    return (row >= 0 && col >= 0 && row < grid.size && col < grid[0].size)
}


package k_november

import java.util.*


/**
 *  Problem 29. Minimum Time to Visit a Cell In a Grid.
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
            intArrayOf(0, 1, 3, 2),
            intArrayOf(5, 1, 2, 5),
            intArrayOf(4, 3, 8, 6)
        ),
        arrayOf(
            intArrayOf(0, 2, 4),
            intArrayOf(3, 2, 1),
            intArrayOf(1, 0, 4)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${minimumTime(grid)}")
    }

}

fun minimumTime(grid: Array<IntArray>): Int {
    if (grid[0][1] > 1 && grid[1][0] > 1) {
        return -1
    }
    val rows: Int = grid.size
    val cols: Int = grid[0].size

    // Possible movements:
    val directions = arrayOf(
        intArrayOf(1, 0), intArrayOf(-1, 0), // down, up,
        intArrayOf(0, 1), intArrayOf(0, -1) // right, left
    )
    val visited = Array(rows) { BooleanArray(cols) }

    // Priority queue stores {time, row, col}
    // Ordered by minimum time to reach each cell
    val pq = PriorityQueue { a: IntArray, b: IntArray -> a[0].compareTo(b[0]) }
    pq.add(intArrayOf(grid[0][0], 0, 0))

    while (!pq.isEmpty()) {
        val curr = pq.poll()
        val time = curr[0]
        val row = curr[1]
        val col = curr[2]

        if (row == rows - 1 && col == cols - 1) {
            return time
        }

        if (visited[row][col]) {
            continue
        }
        visited[row][col] = true

        for (d in directions) {
            val nextRow = row + d[0]
            val nextCol = col + d[1]
            if (!isValidCell(visited, nextRow, nextCol)) {
                continue
            }

            // Calculate the wait time needed to move to next cell
            val waitTime = if ((grid[nextRow][nextCol] - time) % 2 == 0) 1 else 0
            val nextTime = (grid[nextRow][nextCol] + waitTime).coerceAtLeast(time + 1)
            pq.add(intArrayOf(nextTime, nextRow, nextCol))
        }
    }

    return -1
}

private fun isValidCell(visited: Array<BooleanArray>, row: Int, col: Int): Boolean {
    return (row >= 0 && col >= 0 && row < visited.size && col < visited[0].size && !visited[row][col])
}
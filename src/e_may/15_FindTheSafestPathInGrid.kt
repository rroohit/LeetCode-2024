package e_may

import java.util.*

/**
 *  Problem 15. Find the Safest Path in a Grid
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
        listOf(
            listOf(0, 0, 0, 1),
            listOf(0, 0, 0, 0),
            listOf(0, 0, 0, 0),
            listOf(1, 0, 0, 0)
        ) // ans = 2
    )

    testCases.forEach { grid ->
        println("Result ==> ${maximumSafenessFactor(grid)}")
    }


}

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    val grid = grid.map { it.toIntArray() }.toTypedArray()
    val dir = intArrayOf(1, 0, -1, 0, 1)
    val n = grid.size
    val q = mutableListOf<Pair<Int, Int>>()
    grid.forEachIndexed { i, row -> q.addAll(row.withIndex().filter { it.value != 0 }.map { i to it.index }) }
    while (q.isNotEmpty()) {
        val (i, j) = q.removeFirst()
        (0..3).forEach { d ->
            val (x, y) = i + dir[d] to j + dir[d + 1]
            if (minOf(x, y) >= 0 && maxOf(x, y) < n && grid[x][y] == 0) q.add(x to y)
                .also { grid[x][y] = grid[i][j] + 1 }
        }
    }

    val pq =
        PriorityQueue<Triple<Int, Int, Int>> { a, b ->
            if (a.first != b.first) b.first - a.first
            else if (b.second != a.second) b.second - a.second
            else b.third - a.third
        }
    pq.add(Triple(grid[0][0], 0, 0))

    while (pq.peek().let { it.second < n - 1 || it.third < n - 1 }) {
        val (g, i, j) = pq.poll()
        (0..3).forEach { d ->
            val (x, y) = i + dir[d] to j + dir[d + 1]
            if (minOf(x, y) >= 0 && maxOf(x, y) < n && grid[x][y] > 0) pq.add(Triple(minOf(g, grid[x][y]), x, y))
                .also { grid[x][y] *= -1 }
        }
    }
    return pq.peek().first - 1
}
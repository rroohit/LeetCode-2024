package k_november

/**
 *  Problem 21. Count Unguarded Cells in the Grid.
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
        Test21(
            4,
            6,
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 3)),
            arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(1, 4))
        )
    )

    testCases.forEach { test ->
        println(
            "Result ==> ${
                countUnguarded(
                    test.m,
                    test.n,
                    test.guards,
                    test.walls
                )
            }"
        )
    }

}

private const val UNGUARDED = 0
private const val GUARDED = 1
private const val GUARD = 2
private const val WALL = 3

fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
    val grid = Array(m) { IntArray(n) }

    for (guard in guards) {
        grid[guard[0]][guard[1]] = GUARD
    }

    for (wall in walls) {
        grid[wall[0]][wall[1]] = WALL
    }

    for (guard in guards) {
        dfs(guard[0] - 1, guard[1], grid, 'U') // Up
        dfs(guard[0] + 1, guard[1], grid, 'D') // Down
        dfs(guard[0], guard[1] - 1, grid, 'L') // Left
        dfs(guard[0], guard[1] + 1, grid, 'R') // Right
    }

    var count = 0
    for (row in grid) {
        for (cell in row) {
            if (cell == UNGUARDED) count++
        }
    }
    return count
}

private fun dfs(row: Int, col: Int, grid: Array<IntArray>, direction: Char) {
    if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size || grid[row][col] == GUARD || grid[row][col] == WALL
    ) {
        return
    }
    grid[row][col] = GUARDED
    if (direction == 'U') dfs(row - 1, col, grid, 'U') // Up

    if (direction == 'D') dfs(row + 1, col, grid, 'D') // Down

    if (direction == 'L') dfs(row, col - 1, grid, 'L') // Left

    if (direction == 'R') dfs(row, col + 1, grid, 'R') // Right
}

private data class Test21(
    val m: Int,
    val n: Int,
    val guards: Array<IntArray>,
    val walls: Array<IntArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Test21

        if (m != other.m) return false
        if (n != other.n) return false
        if (!guards.contentDeepEquals(other.guards)) return false
        if (!walls.contentDeepEquals(other.walls)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = m
        result = 31 * result + n
        result = 31 * result + guards.contentDeepHashCode()
        result = 31 * result + walls.contentDeepHashCode()
        return result
    }
}
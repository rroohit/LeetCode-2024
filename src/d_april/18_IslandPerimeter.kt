package d_april

/**
 *  Problem 18. Island Perimeter
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *          m - no of rows
 *          n - no of columns
 *
 *       - Space complexity: O(1)
 *          -
 *
 * ## Code -
 */
fun main() {

    val grid = arrayOf(
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 1, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(1, 1, 0, 0)
    )

    println("Result ==> ${islandPerimeter(grid)}")

}

fun islandPerimeter(grid: Array<IntArray>): Int {
    var perimeter = 0

    for (r in grid.indices) { // row
        for (c in grid[0].indices) { // column
            if (grid[r][c] == 1) {
                // Need to check out of four edges how many edges are valid to add in perimeter calculation

                // Left
                if (c - 1 < 0 || grid[r][c - 1] == 0) perimeter++

                // Right
                if (c + 1 >= grid[0].size || grid[r][c + 1] == 0) perimeter++

                // Up
                if (r - 1 < 0 || grid[r - 1][c] == 0) perimeter++

                // Down
                if (r + 1 >= grid.size || grid[r + 1][c] == 0) perimeter++

            }
        }
    }

    return perimeter
}
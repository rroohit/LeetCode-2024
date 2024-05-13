package e_may

/**
 *  Problem 13. Score After Flipping Matrix
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(rowSize * colSize)
 *
 *       - Space complexity:  O(rowSize * colSize)
 *
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
        )
    )

    testCases.forEach {
        println("Result ==> ${matrixScore(it)}")
    }

}

fun matrixScore(grid: Array<IntArray>): Int {
    val rowSize = grid.size
    val colSize = grid.first().size

    for (r in 0..<rowSize) { // each row
        if (grid[r][0] == 0) {
            for (c in 0..<colSize) { // each column
                grid[r][c] = if (grid[r][c] == 0) 1 else 0
            }
        }
    }

    for (c in 0..<colSize) { // each column
        var one = 0
        var zero = 0
        for (r in 0..<rowSize) { // each row
            if (grid[r][c] == 0) zero++
            if (grid[r][c] == 1) one++
        }

        if (zero > one) {
            for (r in 0..<rowSize) { // each row
                grid[r][c] = if (grid[r][c] == 0) 1 else 0
            }
        }
    }

    var score = 0
    for (r in 0..<rowSize) { // each row
        for (c in 0..<colSize) { // each column
            val power = colSize - 1 - c
            score += (grid[r][c] * (Math.pow(2.0, power.toDouble()))).toInt()
        }
    }

    return score
}
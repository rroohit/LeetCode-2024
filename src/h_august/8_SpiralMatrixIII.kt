package h_august

/**
 *  Problem 8. Spiral Matrix III
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(rows * cols)
 *
 *       - Space complexity: O(rows * cols)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        TestDataS(
            rows = 1,
            cols = 4,
            rStart = 0,
            cStart = 0
        ),
        TestDataS(
            rows = 5,
            cols = 6,
            rStart = 1,
            cStart = 4
        ),
    )

    testCases.forEach { test ->
        val result = spiralMatrixIII(test.rows, test.cols, test.rStart, test.cStart).map { it.toList() }
        println("Result ==> $result")
        println()
    }

}

fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
    val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    val result = Array(rows * cols) { intArrayOf(0, 0) }
    var iResult = 0
    var row = rStart
    var col = cStart
    var countTurns = 0

    result[iResult][0] = row
    result[iResult][1] = col
    iResult++

    while (iResult < result.size) {
        val direction = directions[countTurns % directions.size]
        val moves = 1 + (countTurns / 2)
        repeat(moves) {
            row += direction[0]
            col += direction[1]

            if (row in 0..<rows && col in 0..<cols) {
                result[iResult][0] = row
                result[iResult][1] = col
                iResult++
            }
        }
        countTurns++
    }

    return result
}

private data class TestDataS(
    val rows: Int,
    val cols: Int,
    val rStart: Int,
    val cStart: Int
)
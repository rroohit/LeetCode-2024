package g_july

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 19. Lucky Numbers in a Matrix
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m + n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(3, 7, 8),
            intArrayOf(9, 11, 13),
            intArrayOf(15, 16, 17)
        ), // 15
        arrayOf(
            intArrayOf(1, 10, 4, 2),
            intArrayOf(9, 3, 8, 7),
            intArrayOf(15, 16, 17, 12)
        ) // 12
    )

    testCases.forEach { test ->
        println("Result ==> ${luckyNumbers(test)}")
    }

}

fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
    val rowMin = IntArray(matrix.size) { 100002 }
    val colMax = IntArray(matrix[0].size) { 0 }

    for (r in matrix.indices) { // row
        for (c in matrix[0].indices) { // column
            rowMin[r] = min(rowMin[r], matrix[r][c])
            colMax[c] = max(colMax[c], matrix[r][c])
        }
    }

    for (r in matrix.indices) { // row
        for (c in matrix[0].indices) { // column
            if (rowMin[r] == colMax[c]) return listOf(rowMin[r])
        }
    }

    return emptyList()
}
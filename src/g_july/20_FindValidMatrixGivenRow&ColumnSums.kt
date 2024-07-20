package g_july

import kotlin.math.min

/**
 *  Problem 20. Find Valid Matrix Given Row and Column Sums
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
            intArrayOf(3, 8),
            intArrayOf(4, 7)
        ),
        Pair(
            intArrayOf(5, 7, 10),
            intArrayOf(8, 6, 8)
        )
    )

    testCases.forEach { test ->
        val result = restoreMatrix(test.first, test.second)
        result.forEach {
            println(it.toList())
        }
        println()
    }


}

fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
    val result = Array(rowSum.size) { IntArray(colSum.size) { 0 } }
   for (r in result.indices) { // row
       for (c in result[0].indices) { // column
           result[r][c] = min(rowSum[r], colSum[c])
           rowSum[r] -= result[r][c]
           colSum[c] -= result[r][c]
       }
   }
    return result
}
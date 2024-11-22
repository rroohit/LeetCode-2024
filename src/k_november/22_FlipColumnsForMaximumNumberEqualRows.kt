package k_november

import kotlin.math.max


/**
 *  Problem 22. Flip Columns For Maximum Number of Equal Rows.
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
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 1)
        ),
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
    )

    testCases.forEach { matrix ->
        println("Result ==> ${maxEqualRowsAfterFlips(matrix)}")
    }

}

fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
    val patternFrequency: MutableMap<String, Int> = HashMap()

    for (currentRow in matrix) {
        val patternBuilder = StringBuilder("")

        for (col in currentRow.indices) {
            if (currentRow[0] == currentRow[col]) {
                patternBuilder.append("T")
            } else {
                patternBuilder.append("F")
            }
        }

        val rowPattern = patternBuilder.toString()
        patternFrequency[rowPattern] = patternFrequency.getOrDefault(rowPattern, 0) + 1
    }

    var maxFrequency = 0
    for (frequency in patternFrequency.values) {
        maxFrequency = max(frequency.toDouble(), maxFrequency.toDouble()).toInt()
    }

    return maxFrequency
}
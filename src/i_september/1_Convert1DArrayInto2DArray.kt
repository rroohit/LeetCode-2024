package i_september

/**
 *  Problem 1. Convert 1D Array Into 2D Array
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(1) / O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(1, 2, 3, 4),
            2, 2
        ),
        Triple(
            intArrayOf(1, 2, 3),
            1, 3
        ),
        Triple(
            intArrayOf(1, 2),
            1, 1
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${construct2DArray(test.first, test.second, test.third).map { it.toList() }}")
    }

}

fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
    if (m * n != original.size) return emptyArray()
    val resultArray = Array(m) { IntArray(n) }
    var i = 0 // pointer for get element from original array
    for (r in 0..<m) { // row traversal
        for (c in 0..<n) { // column traversal
            resultArray[r][c] = original[i++]
        }
    }
    return resultArray
}
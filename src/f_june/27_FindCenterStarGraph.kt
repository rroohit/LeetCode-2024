package f_june

/**
 *  Problem 27. Find Center of Star Graph
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(5, 1),
            intArrayOf(1, 3),
            intArrayOf(1, 4)
        )
    )

    testCases.forEach { edges ->
        println("Result ==> ${findCenter(edges)}")
    }

}

fun findCenter(edges: Array<IntArray>): Int {
    val eOne = edges[0]
    val eTwo = edges[1]
    return if (eOne[0] == eTwo[0] || eOne[0] == eTwo[1]) eOne[0] else eOne[1]
}
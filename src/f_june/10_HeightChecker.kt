package f_june

/**
 *  Problem 8.  Height Checker
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 1, 4, 2, 1, 3),
        intArrayOf(5, 1, 2, 3, 4),
        intArrayOf(4, 1, 5)
    )

    testCases.forEach { heights ->
        println("Result ==> ${heightChecker(heights)}")
    }

}

fun heightChecker(heights: IntArray): Int {
    val expected = heights.sorted()
    var count = 0

    for (i in heights.indices) {
        if (heights[i] != expected[i]) count++
    }

    return count
}













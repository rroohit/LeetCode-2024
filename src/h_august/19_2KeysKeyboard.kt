package h_august

import kotlin.math.min

/**
 *  Problem 19. 2 Keys Keyboard
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(2^n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(3, 1)

    testCases.forEach { n ->
        println("Result ==> ${minSteps(n)}")
    }

}

private var k = -1
fun minSteps(n: Int): Int {
    if (n == 1) return 0
    k = n
    return 1 + minStepsFinder(1, 1)
}

private fun minStepsFinder(i : Int, j : Int): Int {
    // base case
    if (i == k) return 0

    // base case not valid A's return max
    if (i > k) return 1000

    // Still need to perform operations
    val optOne = 2 + minStepsFinder(i * 2, i)
    val optTwo = 1 + minStepsFinder(i + j, j)
    return min(optOne, optTwo)
}
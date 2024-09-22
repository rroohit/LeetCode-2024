package i_september

import kotlin.math.min

/**
 *  Problem 22. K-th Smallest in Lexicographical Order
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log(n)^2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(13, 2),
        Pair(10000, 10000),
        Pair(681692778,351251360) // 416126219
    )

    testCases.forEach { test ->
        println("Result ==> ${findKthNumber(test.first, test.second)}")
    }

}


fun findKthNumber(n: Int, k: Int): Int {
    var curr = 1
    var kk = k -1

    while (kk > 0) {
        val steps = countSteps(n, curr, curr + 1)
        if (steps <= kk) {
            curr++
            kk -= steps
        } else {
            curr *= 10
            kk--
        }
    }

    return curr
}

private fun countSteps(n: Int, p1: Int, p2: Int): Int {
    var prefix1 = p1.toLong()
    var prefix2 = p2.toLong()
    var steps =0

    while (prefix1 <= n) {
        steps += (min(n + 1L, prefix2) - prefix1).toInt()
        prefix1 *= 10
        prefix2 *= 10
    }

    return steps
}
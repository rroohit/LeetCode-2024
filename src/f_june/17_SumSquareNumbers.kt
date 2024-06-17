package f_june

import kotlin.math.sqrt

/**
 *  Problem 17. Sum of Square Numbers
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        5,
        1,
        3
    )

    testCases.forEach { c ->
        println("Result ==> ${judgeSquareSum(c)}")
    }

}

fun judgeSquareSum(c: Int): Boolean {
    val limit = sqrt(c.toDouble()).toInt()
    val reminders = HashSet<Int>()
    for (i in 0..limit) {
        val currSquare = i * i
        if (reminders.contains(c - currSquare) || (currSquare + currSquare) == c) {
            return true
        }
        reminders.add(currSquare)
    }
    return false
}
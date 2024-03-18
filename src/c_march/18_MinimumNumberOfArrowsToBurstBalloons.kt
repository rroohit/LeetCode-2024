package c_march

import kotlin.math.min

/**
 *  Problem 18. Minimum Number of Arrows to Burst Balloons
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *          - n as we are visiting all given array elements n len of given array
 *          - logn required for sorting
 *          -
 *
 *       - Space complexity: O(n)
 *          - space required for sorting.
 *
 * ## Code -
 */
fun main() {

    val points = arrayOf(
        intArrayOf(10, 16),
        intArrayOf(2, 8),
        intArrayOf(1, 6),
        intArrayOf(7, 12)
    )

    println("Result ==> ${findMinArrowShots(points)}")

}

fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    var res = points.size
    var prev = points.first()

    for (i in 1..< points.size) {
        val curr = points[i]

        if (curr[0] <= prev[1]) {
            res--
            prev = intArrayOf(curr.first(), min(curr[1], prev[1]))
        } else {
            prev = curr
        }
    }

    return res
}
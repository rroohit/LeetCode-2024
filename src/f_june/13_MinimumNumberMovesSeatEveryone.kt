package f_june

import kotlin.math.abs

/**
 *  Problem 13. Minimum Number of Moves to Seat Everyone
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
        Pair(intArrayOf(3, 1, 5), intArrayOf(2, 7, 4)),
        Pair(intArrayOf(4, 1, 5, 9), intArrayOf(1, 3, 2, 6))
    )

    testCases.forEach { test ->
        println("Result ==> ${minMovesToSeat(test.first, test.second)}")
    }

}

fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    seats.sort() // TC - O(n log n)
    students.sort() // TC - O(n log n)
    var moves = 0

    for (i in seats.indices) { // // TC - O(n)
        moves += abs(seats[i] - students[i])
    }

    return moves
}
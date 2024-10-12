package j_october

import java.util.*

/**
 *  Problem 12. Divide Intervals Into Minimum Number of Groups.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N logN)
 *
 *       - Space complexity: (N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(5, 10),
            intArrayOf(6, 8),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(1, 10)
        )
    )

    testCases.forEach { intervals ->
        println("Result ==> ${minGroups(intervals)}")
    }

}

fun minGroups(intervals: Array<IntArray>): Int {
    intervals.sortWith(compareBy { it[0] })
    val pq = PriorityQueue<Int>()
    var grp = 1
    pq.add(intervals[0][1])
    for (i in 1..<intervals.size) {
        if (pq.peek() < intervals[i][0]) {
            pq.poll()
        } else {
            grp++
        }
        pq.add(intervals[i][1])
    }
    return grp
}
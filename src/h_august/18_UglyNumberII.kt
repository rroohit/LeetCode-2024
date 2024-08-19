package h_august

import java.util.*

/**
 *  Problem 18. Ugly Number II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * logN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        10,
        1
    )

    testCases.forEach { n ->
        println("Result ==> ${nthUglyNumber(n)}")
    }

}

fun nthUglyNumber(n: Int): Int {
    val set = HashSet<Long>()
    val pq = PriorityQueue<Long>()
    var nth = 0L

    pq.offer(1L)

    for (i in 1..n) {
        nth = pq.poll()

        val u2 = nth * 2L
        val u3 = nth * 3L
        val u5 = nth * 5L

        if (!set.contains(u2)) {
            set.add(u2)
            pq.offer(u2)
        }
        if (!set.contains(u3)) {
            set.add(u3)
            pq.offer(u3)
        }
        if (!set.contains(u5)) {
            set.add(u5)
            pq.offer(u5)
        }
    }

    return nth.toInt()
}
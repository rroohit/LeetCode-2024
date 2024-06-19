package f_june

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 19.  Minimum Number of Days to Make m Bouquets
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(NLog(D))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        BloomFlowers(
            intArrayOf(1, 10, 3, 10, 2),
            3,
            1
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minDays(test.bloomDay, test.m, test.k)}")
    }

}

fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
    val n = bloomDay.size.toLong()
    if (n < m.toLong() * k) return -1

    var days = 0
    var l = Int.MAX_VALUE
    var r = Int.MIN_VALUE
    for (num in bloomDay) {
        l = min(num, l)
        r = max(num, r)
    }

    while (l <= r) {
        val mid = (l + r) / 2
        val canCreateBqt = canCreateAllBqt(bloomDay, m, k, mid)
        if (canCreateBqt) {
            days = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }

    return days
}

private fun canCreateAllBqt(bloomDay: IntArray, m: Int, k: Int, mid: Int): Boolean {
    var noOfBqt = 0
    var grpCnt = 0 // group count
    for (bloom in bloomDay) {
        if (bloom <= mid) grpCnt++ else grpCnt = 0
        if (grpCnt == k) {
            noOfBqt++
            grpCnt = 0
        }
    }
    return noOfBqt >= m
}

data class BloomFlowers(
    val bloomDay: IntArray,
    val m: Int,
    val k: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BloomFlowers

        if (!bloomDay.contentEquals(other.bloomDay)) return false
        if (m != other.m) return false
        if (k != other.k) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bloomDay.contentHashCode()
        result = 31 * result + m
        result = 31 * result + k
        return result
    }
}
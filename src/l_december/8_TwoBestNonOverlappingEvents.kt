package l_december

import java.util.*
import kotlin.math.max


/**
 *  Problem 8. Two Best Non-Overlapping Events.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logN)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(intArrayOf(1, 3, 2), intArrayOf(4, 5, 2), intArrayOf(2, 4, 3))
    )

    testCases.forEach { events ->
        println("Result ==> ${maxTwoEvents(events)}")
    }

}

fun maxTwoEvents(events: Array<IntArray>): Int {
    Arrays.sort(events) { a: IntArray, b: IntArray -> a[0] - b[0] }
    val dp = Array(events.size) { IntArray(3) }
    for (d in dp) Arrays.fill(d, -1)
    return findEvents(events, 0, 0, dp)
}

private fun findEvents(events: Array<IntArray>, idx: Int, cnt: Int, dp: Array<IntArray>): Int {
    if (cnt == 2 || idx >= events.size) return 0
    if (dp[idx][cnt] == -1) {
        val end = events[idx][1]
        var lo = idx + 1
        var hi = events.size - 1
        while (lo < hi) {
            val mid = lo + ((hi - lo) shr 1)
            if (events[mid][0] > end) hi = mid
            else lo = mid + 1
        }
        val include =
            events[idx][2] +
                    (if (lo < events.size && events[lo][0] > end)
                        findEvents(events, lo, cnt + 1, dp)
                    else
                        0)
        val exclude = findEvents(events, idx + 1, cnt, dp)
        dp[idx][cnt] = max(include.toDouble(), exclude.toDouble()).toInt()
    }
    return dp[idx][cnt]
}
package i_september

import kotlin.math.min

/**
 *  Problem 16. Minimum Time Difference
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N LogN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf("23:59", "00:00"),
        listOf("00:00", "23:59", "00:00")
    )

    testCases.forEach { test ->
        println("Result ==> ${findMinDifference(test)}")
        println()
    }

}

/// Bucket Sort
fun findMinDifference(timePoints: List<String>): Int {
    val bucket = IntArray(1440)
    for (time in timePoints) {
        bucket[time.toMinutes()]++
    }

    val arrMinutes = IntArray(timePoints.size)
    var p = 0
    for ((i, count) in bucket.withIndex()) {
        if (count > 0) {
            repeat(count) {
                arrMinutes[p++] = i
            }
        }
    }

    var minMinute = 1440
    for (i in 0..<arrMinutes.size - 1) {
        minMinute = min(minMinute, arrMinutes[i + 1] - arrMinutes[i])
    }
    val loopMinDiff = 1440 - (arrMinutes.last() - arrMinutes.first())
    return min(loopMinDiff, minMinute)
}


// TC - O(N LogN) :: SC - O(N)
fun findMinDifference1(timePoints: List<String>): Int {
    val arrMinutes = IntArray(timePoints.size)
    for ((ind, time) in timePoints.withIndex()) {
        arrMinutes[ind] = time.toMinutes()
    }

    arrMinutes.sort()
    var minMinute = 1440
    for (i in 0..<arrMinutes.size - 1) {
        minMinute = min(minMinute, arrMinutes[i + 1] - arrMinutes[i])
    }

    val loopMinDiff = 1440 - (arrMinutes.last() - arrMinutes.first())
    return min(loopMinDiff, minMinute)
}

private fun String.toMinutes(): Int {
    val hr = substring(0, 2).toInt()
    val min = substring(3).toInt()
    return (hr * 60) + min
}
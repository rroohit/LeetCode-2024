package h_august

import kotlin.math.max

/**
 *  Problem 17. Maximum Number of Points with Cost
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
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 5, 1),
            intArrayOf(3, 1, 1)
        )
    )

    testCases.forEach { points ->
        println("Result ==> ${maxPoints(points)}")
    }

}

fun maxPoints(points: Array<IntArray>): Long {
    val n = points[0].size

    var currentRowMaxPoints = LongArray(n)

    val inf = 1L shl 60
    for (row in points) {
        val nextRowMaxPoints = LongArray(n)

        var leftMax = -inf
        var rightMax = -inf

        for (j in 0..<n) {
            leftMax = max(leftMax, currentRowMaxPoints[j] + j)
            nextRowMaxPoints[j] = max(nextRowMaxPoints[j], row[j] + leftMax - j)
        }

        for (j in n - 1 downTo 0) {
            rightMax = max(rightMax, currentRowMaxPoints[j] - j)
            nextRowMaxPoints[j] = max(nextRowMaxPoints[j], row[j] + rightMax + j)
        }

        currentRowMaxPoints = nextRowMaxPoints
    }
    return currentRowMaxPoints.max()
}
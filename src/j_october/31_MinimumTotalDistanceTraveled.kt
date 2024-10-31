package j_october

import java.util.*
import kotlin.math.abs
import kotlin.math.min


/**
 *  Problem 31. Minimum Total Distance Traveled
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n * m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            listOf(0, 4, 6),
            arrayOf(
                intArrayOf(2, 2),
                intArrayOf(6, 2)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumTotalDistance(test.first, test.second)}")
    }

}

fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
    val sortedRobot = robot.sorted()
    Arrays.sort(factory, Comparator.comparingInt { a: IntArray -> a[0] })

    // Flatten factory positions according to their capacities
    val factoryPositions: MutableList<Int> = ArrayList()
    for (f in factory) {
        for (i in 0..<f[1]) {
            factoryPositions.add(f[0])
        }
    }

    val robotCount = sortedRobot.size
    val factoryCount = factoryPositions.size

    val dp = Array(robotCount + 1) { LongArray(factoryCount + 1) }

    // Initialize base cases
    for (i in 0..<robotCount) {
        dp[i][factoryCount] = 1e12.toLong() // No factories left
    }

    // Fill DP table bottom-up
    for (i in robotCount - 1 downTo 0) {
        for (j in factoryCount - 1 downTo 0) {
            // Option 1: Assign current robot to current factory
            val assign =
                (abs((sortedRobot[i] - factoryPositions[j]).toDouble()) +
                        dp[i + 1][j + 1]).toLong()

            // Option 2: Skip current factory for the current robot
            val skip = dp[i][j + 1]

            // Take the minimum option
            dp[i][j] = min(assign.toDouble(), skip.toDouble()).toLong()
        }
    }

    // Minimum distance starting from first robot and factory
    return dp[0][0]
}


// time limit exceeds
fun minimumTotalDistance1(robot: List<Int>, factory: Array<IntArray>): Long {
    val sortedRobot = robot.sorted()
    Arrays.sort(factory, Comparator.comparingInt { a: IntArray -> a[0] })

    val factoryPositions: MutableList<Int> = ArrayList()
    for (f in factory) {
        for (i in 0..<f[1]) {
            factoryPositions.add(f[0])
        }
    }

    return calculateMinDistance(0, 0, sortedRobot, factoryPositions)
}

private fun calculateMinDistance(
    robotIdx: Int,
    factoryIdx: Int,
    robot: List<Int>,
    factoryPositions: List<Int>
): Long {
    // All robots assigned
    if (robotIdx == robot.size) return 0
    // No factories left to assign
    if (factoryIdx == factoryPositions.size) return 1e12.toLong()

    // Option 1: Assign current robot to current factory
    val assign =
        (abs((robot[robotIdx] - factoryPositions[factoryIdx]).toDouble()) +
                calculateMinDistance(
                    robotIdx + 1,
                    factoryIdx + 1,
                    robot,
                    factoryPositions
                )).toLong()

    // Option 2: Skip current factory for the current robot
    val skip = calculateMinDistance(
        robotIdx,
        factoryIdx + 1,
        robot,
        factoryPositions
    )

    // Take the minimum and store in memo
    return min(assign.toDouble(), skip.toDouble()).toLong()
}
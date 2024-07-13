package g_july

import java.util.*

/**
 *  Problem 13. Robot Collisions
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {
    val testCases = listOf(
        RobotData(
            positions = intArrayOf(5, 4, 3, 2, 1),
            healths = intArrayOf(2, 17, 9, 15, 10),
            directions = "RRRRR"
        ),
        RobotData(
            positions = intArrayOf(3, 5, 2, 6),
            healths = intArrayOf(10, 10, 15, 12),
            directions = "RLRL"
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${survivedRobotsHealths(test.positions, test.healths, test.directions)}")
        println()
    }
}

fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
    val robotDataList = mutableListOf<RobotD>()
    for (i in positions.indices) {
        robotDataList.add(
            RobotD(
                positions[i],
                healths[i],
                directions[i],
                i
            )
        )
    }

    robotDataList.sortBy { it.position }

    val stack = Stack<RobotD>()
    for (currRobot in robotDataList) {
        if (currRobot.direction == 'R') {
            stack.push(currRobot)
        } else {


        }
    }

    stack.sortBy { it.index }
    return stack.map { it.health }
}

data class RobotD(
    val position: Int,
    var health: Int,
    val direction: Char,
    val index: Int
)

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
data class Robot(var position: Int, var health: Int, var direction: Char, val index: Int)

enum class DIRECTION(val value: Char) {
    LEFT('L'),
    RIGHT('R')
}

fun survivedRobotsHealths1(positions: IntArray, healths: IntArray, directions: String): List<Int> {
    var robots =
        positions.withIndex().map { (index, position) -> Robot(position, healths[index], directions[index], index) }
            .toMutableList()
    robots.sortBy { it.position }
    var rightRobots = mutableListOf<Robot>()

    for (robot in robots) {
        if (robot.direction == DIRECTION.RIGHT.value) {
            rightRobots.add(robot)
        } else { // Left robot
            while (rightRobots.isNotEmpty() && robot.health > 0) {
                val rightRobot = rightRobots.removeLast()
                if (rightRobot.health > robot.health) {
                    rightRobot.health -= 1
                    robot.health = 0
                    rightRobots.add(rightRobot)
                } else if (rightRobot.health < robot.health) {
                    robot.health -= 1
                    rightRobot.health = 0
                } else {
                    robot.health = 0
                    rightRobot.health = 0
                }
            }
        }
    }
    robots.sortBy { it.index }

    return robots.filter { it.health > 0 }.map { it.health }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


data class RobotData(
    val positions: IntArray,
    val healths: IntArray,
    val directions: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RobotData

        if (!positions.contentEquals(other.positions)) return false
        if (!healths.contentEquals(other.healths)) return false
        if (directions != other.directions) return false

        return true
    }

    override fun hashCode(): Int {
        var result = positions.contentHashCode()
        result = 31 * result + healths.contentHashCode()
        result = 31 * result + directions.hashCode()
        return result
    }
}
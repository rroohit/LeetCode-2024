package i_september

/**
 *  Problem 4. Walking Robot Simulation
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
        Pair(
            intArrayOf(4, -1, 3),
            arrayOf()
        ),
        Pair(
            intArrayOf(4, -1, 4, -2, 4),
            arrayOf(intArrayOf(2, 4))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${robotSim(test.first, test.second)}")
    }

}

fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
    val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

    val obstaclesSet: MutableSet<String> = HashSet()
    for (obstacle in obstacles) {
        obstaclesSet.add(obstacle[0].toString() + "," + obstacle[1])
    }
    var x = 0
    var y = 0
    var direction = 0
    var maxDistance = 0

    for (command in commands) {
        when (command) {
            -2 -> {
                direction = (direction + 3) % 4
            }

            -1 -> {
                direction = (direction + 1) % 4
            }

            else -> {
                var step = 0
                while (step < command
                    && !obstaclesSet.contains("${x + directions[direction][0]},${y + directions[direction][1]}")
                ) {
                    x += directions[direction][0]
                    y += directions[direction][1]
                    step++
                }
            }
        }
        maxDistance = maxDistance.coerceAtLeast(x * x + y * y)
    }
    return maxDistance
}
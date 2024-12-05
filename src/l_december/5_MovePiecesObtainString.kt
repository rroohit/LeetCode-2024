package l_december

/**
 *  Problem 5. Move Pieces to Obtain a String.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("_L__R__R_", "L______RR")
    )

    testCases.forEach { test ->
        println("Result ==> ${canChange(test.first, test.second)}")
    }

}

fun canChange(start: String, target: String): Boolean {
    val startLength: Int = start.length
    var startIndex = 0
    var targetIndex = 0

    while (startIndex < startLength || targetIndex < startLength) {
        // Skip underscores in start
        while (startIndex < startLength && start[startIndex] == '_') startIndex++

        // Skip underscores in target
        while (targetIndex < startLength && target[targetIndex] == '_') targetIndex++

        // If one string is exhausted, both should be exhausted
        if (startIndex == startLength || targetIndex == startLength) {
            return startIndex == startLength && targetIndex == startLength
        }

        // Check if the pieces match and follow movement rules
        if (start[startIndex] != target[targetIndex] ||
            (start[startIndex] == 'L' && startIndex < targetIndex) ||
            (start[startIndex] == 'R' && startIndex > targetIndex)
        ) return false

        startIndex++
        targetIndex++
    }

    return true
}


package j_october

/**
 *  Problem 15. Separate Black and White Balls
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "101",
        "100",
        "0111",
        "10010011"
    )

    testCases.forEach { s ->
        println("Result ==> ${minimumSteps(s)}")
    }

}

//
fun minimumSteps(s: String): Long {
    var steps = 0L
    var zeros = 0L
    for (i in s.length - 1 downTo 0) {
        if (s[i] == '0') zeros++
        if (s[i] == '1') steps += zeros
    }
    return steps
}
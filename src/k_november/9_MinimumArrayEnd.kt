package k_november

/**
 *  Problem 9. Minimum Array End.
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
        Pair(2, 4),
        Pair(2, 7)
    )

    testCases.forEach { test ->
        println("Result ==> ${minEnd(test.first, test.second)}")
    }

}

fun minEnd(n: Int, x: Int): Long {
    var result = x.toLong()
    repeat(n - 1) {
        result = (result + 1) or x.toLong()
    }
    return result
}
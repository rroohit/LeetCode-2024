package j_october

/**
 *  Problem 8. Minimum Number of Swaps to Make the String Balanced
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
        "][][",
        "]]][[[",
        "[]"
    )

    testCases.forEach { s ->
        println("Result ==> ${minSwaps(s)}")
    }

}

fun minSwaps(s: String): Int {
    var openBracketsCount = 0
    var unbalancedCount = 0

    for (ch in s) {
        if (ch == '[') {
            openBracketsCount++
        } else {
            if (openBracketsCount > 0) openBracketsCount-- else unbalancedCount++
        }
    }

    return (unbalancedCount + 1) / 2
}
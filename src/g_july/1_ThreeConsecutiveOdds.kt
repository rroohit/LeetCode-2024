package g_july

/**
 *  Problem 1. Three Consecutive Odds
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
        intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12),// true
        intArrayOf(2, 6, 4, 1)
    )

    testCases.forEach { arr ->
        println("Result ==> ${threeConsecutiveOdds(arr)}")
    }

}

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    for (i in 1..<arr.size - 1) {
        if ((arr[i - 1] and 1) +
            (arr[i] and 1) +
            (arr[i + 1] and 1) == 3
        ) return true
    }

    return false
}
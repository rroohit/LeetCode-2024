package g_july

/**
 *  Problem 29. Count Number of Teams
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^3)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(2, 5, 3, 4, 1),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(2, 1, 3)
    )

    testCases.forEach { rating ->
        println("Result ==> ${numTeams(rating)}")
    }

}

fun numTeams(rating: IntArray): Int {
    var totalTeam = 0
    for (i in rating.indices) {
        for (j in i + 1..<rating.size) {
            for (k in j + 1..<rating.size) {
                if ((rating[i] < rating[j] && rating[j] < rating[k]) ||
                    (rating[i] > rating[j] && rating[j] > rating[k])
                ) totalTeam++
            }
        }
    }
    return totalTeam
}
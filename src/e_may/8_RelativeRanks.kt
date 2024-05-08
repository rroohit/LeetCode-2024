package e_may

/**
 *  Problem 8. Relative Ranks
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *          - due to the sorting operation.
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(9, 8, 1, 2, 3, 5, 4, 3, 2, 1),
        intArrayOf(5, 4, 3, 2, 1),
        intArrayOf(10, 3, 8, 9, 4)
    )

    testCases.forEach { score ->
        println("Result ==> ${findRelativeRanks(score).toList()}")
    }

}

fun findRelativeRanks(score: IntArray): Array<String> {
    val scoreIndex = score.mapIndexed { index, s -> Pair(s, index) }
    val l = scoreIndex.sortedByDescending { it.first }

    val winners = Array(score.size) { "" }
    l.forEachIndexed { index, pair ->
        when (index) {
            0 -> winners[pair.second] = "Gold Medal"
            1 -> winners[pair.second] = "Silver Medal"
            2 -> winners[pair.second] = "Bronze Medal"
            else -> winners[pair.second] = "${index + 1}"
        }
    }
    return winners
}
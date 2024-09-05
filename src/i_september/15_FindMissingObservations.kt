package i_september

/**
 *  Problem 5. Find Missing Observations
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(max(m, n))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(3, 2, 4, 3),
            4, 2
        ),
        Triple(
            intArrayOf(1, 5, 6),
            3, 4
        ),
        Triple(
            intArrayOf(1, 2, 3, 4),
            6, 4
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${missingRolls(test.first, test.second, test.third).toList()}")
    }

}

fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
    val totalSum = rolls.sum()
    val remainSum = (mean * (n + rolls.size)) - totalSum

    if (remainSum > (6 * n) || remainSum < n) return intArrayOf()

    val avgValue = remainSum / n
    val mod = remainSum % n

    val result = IntArray(n) { avgValue }
    repeat(mod) {
        result[it]++
    }

    return result
}
package k_november

/**
 *  Problem 7. Largest Combination With Bitwise AND Greater Than Zero.
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
        intArrayOf(16, 17, 71, 62, 12, 24, 14),
        intArrayOf(8, 8)
    )

    testCases.forEach { candidates ->
        println("Result ==> ${largestCombination(candidates)}")
    }


}

fun largestCombination(candidates: IntArray): Int {
    val bitCount = IntArray(24)
    for (i in 0..23) {
        for (num in candidates) {
            if ((num and (1 shl i)) != 0) {
                bitCount[i]++
            }
        }
    }

    var max = 0
    for (count in bitCount) {
        if (count > max) {
            max = count
        }
    }

    return max
}
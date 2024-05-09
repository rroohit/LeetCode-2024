package e_may

import kotlin.math.max

/**
 *  Problem 9. Maximize Happiness of Selected Children
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(2, intArrayOf(1, 2, 3)),
        Pair(2, intArrayOf(1, 1, 1, 1)),
        Pair(1, intArrayOf(2, 3, 4, 5)),
    )

    testCases.forEach {
        println("Result ==> ${maximumHappinessSum(it.second, it.first)}")
    }


}

fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    happiness.sort() // TC - O(n log n)

    val n = happiness.size - 1
    var maxHappy = 0L

    repeat(k) { index -> // TC - O(n)
        maxHappy += max(0, happiness[n - index] - index)
    }

    return maxHappy
}
package i_september

/**
 *  Problem 2. Find the Student that Will Replace the Chalk
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
        Pair(intArrayOf(5, 1, 5), 22),
        Pair(intArrayOf(3, 4, 1, 2), 25)
    )

    testCases.forEach { test ->
        println("Result ==> ${chalkReplacer(test.first, test.second)}")
    }

}

fun chalkReplacer(chalk: IntArray, k: Int): Int {
    var sum = 0
    for (c in chalk) {
        sum += c
        if (sum > k) break
    }

    var kk = k % sum
    for (i in chalk.indices) {
        if (chalk[i] > kk) return i
        kk -= chalk[i]
    }

    return -1
}
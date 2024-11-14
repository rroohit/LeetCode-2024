package k_november

/**
 *  Problem 14. Minimized Maximum of Products Distributed to Any Store.
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
        Pair(
            6,
            intArrayOf(11, 6)
        ),
        Pair(
            7,
            intArrayOf(15, 10, 10)
        ),
        Pair(
            1,
            intArrayOf(100000)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimizedMaximum(test.first, test.second)}")
    }

}

fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    var left = 0
    var right = quantities.maxOrNull() ?: 0

    while (left < right) {
        val middle = (left + right) / 2
        if (canDistribute(middle, quantities, n)) {
            right = middle
        } else {
            left = middle + 1
        }
    }
    return left
}

fun canDistribute(x: Int, quantities: IntArray, n: Int): Boolean {
    var j = 0
    var remaining = quantities[j]
    for (i in 0..<n) {
        if (remaining <= x) {
            j++
            if (j == quantities.size) {
                return true
            } else {
                remaining = quantities[j]
            }
        } else {
            remaining -= x
        }
    }
    return false
}
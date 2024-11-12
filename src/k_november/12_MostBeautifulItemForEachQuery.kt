package k_november

import java.util.*
import kotlin.math.max


/**
 *  Problem 12. Most Beautiful Item for Each Query.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(2, 4),
                intArrayOf(5, 6),
                intArrayOf(3, 5)
            ),
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumBeauty(test.first, test.second).toList()}")
    }

}

fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
    Arrays.sort(items) { a: IntArray, b: IntArray -> a[0] - b[0] }
    var max = items[0][1]
    for (i in items.indices) {
        max = max(max, items[i][1])
        items[i][1] = max
    }

    val result = IntArray(queries.size)
    for (i in result.indices) {
        result[i] = binarySearch(items, queries[i])
    }

    return result
}

private fun binarySearch(items: Array<IntArray>, targetPrice: Int): Int {
    var l = 0
    var r = items.size - 1
    var maxBeauty = 0
    while (l <= r) {
        val mid = (l + r) / 2
        if (items[mid][0] > targetPrice) {
            r = mid - 1
        } else {
            maxBeauty = max(maxBeauty, items[mid][1])
            l = mid + 1
        }
    }
    return maxBeauty
}
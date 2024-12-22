package l_december

import java.util.*
import kotlin.math.max


/**
 *  Problem 22. Find Building Where Alice and Bob Can Meet.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(q * logn)
 *
 *       - Space complexity: O(n + q)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(6, 4, 8, 5, 2, 7),
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 3), intArrayOf(2, 4), intArrayOf(3, 4), intArrayOf(2, 2))
        )// Output: [2,5,-1,5,2]

    )

    testCases.forEach { test ->
        println("Result ==> ${leftmostBuildingQueries(test.first, test.second).toList()}")
    }

}

fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
    val monoStack: MutableList<Pair<Int, Int>> = ArrayList()
    val result = IntArray(queries.size)
    Arrays.fill(result, -1)
    val newQueries: MutableList<MutableList<Pair<Int, Int>>> = ArrayList(heights.size)

    for (i in heights.indices) {
        newQueries.add(ArrayList())
    }

    for (i in queries.indices) {
        var a = queries[i][0]
        var b = queries[i][1]
        if (a > b) {
            val temp = a
            a = b
            b = temp
        }
        if (heights[b] > heights[a] || a == b) {
            result[i] = b
        } else {
            newQueries[b].add(Pair(heights[a], i))
        }
    }

    for (i in heights.indices.reversed()) {
        val monoStackSize = monoStack.size
        for (pair in newQueries[i]) {
            val position = search(pair.first, monoStack)
            if (position in 0..<monoStackSize) {
                result[pair.second] = monoStack[position].second
            }
        }

        while (monoStack.isNotEmpty() &&
            monoStack[monoStack.size - 1].first <= heights[i]
        ) {
            monoStack.removeAt(monoStack.size - 1)
        }

        monoStack.add(Pair(heights[i], i))
    }

    return result
}

private fun search(height: Int, monoStack: List<Pair<Int, Int>>): Int {
    var left = 0
    var right = monoStack.size - 1
    var ans = -1
    while (left <= right) {
        val mid = (left + right) / 2
        if (monoStack[mid].first > height) {
            ans = max(ans.toDouble(), mid.toDouble()).toInt()
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return ans
}

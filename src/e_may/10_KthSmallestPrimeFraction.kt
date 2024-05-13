package e_may

import java.util.*

/**
 *  Problem 10. K-th Smallest Prime Fraction
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2 log n)
 *          -  where n is the size of the input array.
 *
 *       - Space complexity: O(n ^ 2)
 *          - Combining all the factors,
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(3, intArrayOf(1, 2, 3, 5)),
        Pair(1, intArrayOf(1, 7))
    )

    testCases.forEach {
        println("Result ==> ${kthSmallestPrimeFraction(it.second, it.first).toList()}")
    }

}

// Brute force
fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    val qu = PriorityQueue<Pair<Float, Pair<Int, Int>>>(compareBy { it.first })

    for (i in arr.indices) {
        val iNum = arr[i]
        for (j in i + 1..<arr.size) {
            val jNum = arr[j]
            val fact = iNum.toFloat() / jNum.toFloat()
            qu.add(fact to Pair(iNum, jNum))
        }
    }

    var r = k
    while (qu.isNotEmpty()) {
        r--
        val top = qu.remove()
        if (r == 0) {
            return intArrayOf(top.second.first, top.second.second)
        }
    }

    return intArrayOf()

}
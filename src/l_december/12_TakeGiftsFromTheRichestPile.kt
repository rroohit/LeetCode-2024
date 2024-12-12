package l_december

import java.util.*
import kotlin.math.round
import kotlin.math.sqrt

/**
 *  Problem 12. Take Gifts From the Richest Pile.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * logN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(25, 64, 9, 4, 100), 4)
    )

    testCases.forEach { test ->
        println("Result ==> ${pickGifts(test.first, test.second)}")
    }

}

fun pickGifts(gifts: IntArray, k: Int): Long {
    var total = 0L
    val maxGifts = PriorityQueue<Int> { a, b -> b - a }

    for (gift in gifts) {
        total += gift
        maxGifts.offer(gift)
    }

    var kk = k
    while (kk > 0) {
        val gift = maxGifts.poll()
        val sq = round(sqrt(gift.toDouble())).toInt()
        total -= (gift - sq)
        kk--
        maxGifts.offer(sq)
    }

    return total
}








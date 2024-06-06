package f_june

import java.util.*

/**
 *  Problem 6. Hand of Straights
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3),
        Pair(intArrayOf(1, 2, 3, 4, 5), 4)
    )

    testCases.forEach { test ->
        println("Result ==> ${isNStraightHand(test.first, test.second)}")
        println()
    }

}

fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
    val freqCount = HashMap<Int, Int>()
    for (num in hand) {
        freqCount[num] = freqCount.getOrDefault(num, 0) + 1
    }

    val heap = PriorityQueue(freqCount.keys)

    while (heap.isNotEmpty()) {
        val first = heap.peek()!!
        for (nextNum in first ..< (first + groupSize)) {

            if (!freqCount.contains(nextNum)) return false
            freqCount[nextNum] = freqCount[nextNum]!! - 1
            if (freqCount[nextNum] == 0) { // ready to remove from min heap
                // if the next num in heap is not equal to nextNum can't make group
                if (nextNum != heap.peek()!!) return false
                heap.poll()
            }
        }
    }

    return true
}
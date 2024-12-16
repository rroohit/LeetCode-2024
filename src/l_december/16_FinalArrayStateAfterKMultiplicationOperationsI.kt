package l_december

import java.util.*

/**
 *  Problem 16. Final Array State After K Multiplication Operations I
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(nlogn + klogn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            intArrayOf(2, 1, 3, 5, 6), 5, 2
        ),
        Triple(
            intArrayOf(1, 2), 3, 4
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${getFinalState(test.first, test.second, test.third).toList()}")
    }

}

fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
    // value -> index
    val prQue = PriorityQueue<Pair<Int, Int>>() { a, b ->
        if (a.first == b.first) a.second - b.second else a.first - b.first
    }

    for ((i, num) in nums.withIndex()) {
        prQue.offer(Pair(num, i))
    }

    repeat(k) {
        val pair = prQue.poll() ?: return@repeat
        nums[pair.second] *= multiplier
        prQue.offer(Pair(nums[pair.second], pair.second))
    }

    return nums
}
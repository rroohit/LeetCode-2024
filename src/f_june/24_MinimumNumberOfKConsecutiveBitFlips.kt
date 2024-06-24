package f_june

import java.util.*

/**
 *  Problem 24. Minimum Number of K Consecutive Bit Flips
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(k)
 *          - at most only K elements are stored in Queue
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(0, 0, 1), 1),
        Pair(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${minKBitFlips(test.first, test.second)}")
    }

}

fun minKBitFlips(nums: IntArray, k: Int): Int {
    var flips = 0
    val queue = LinkedList<Int>()

    for (r in nums.indices) {
        while (queue.isNotEmpty() && r > queue.peek()!! + k - 1) {
            queue.pop()
        }

        if (nums[r] + queue.size and 1 == 0) {
            if (r + k > nums.size) return -1
            flips++
            queue.offer(r)
        }
    }

    return flips
}
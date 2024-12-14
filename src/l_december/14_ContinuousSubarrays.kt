package l_december

import java.util.*


/**
 *  Problem 14. Continuous Subarrays.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(5, 4, 2, 4),
        intArrayOf(1, 2, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${continuousSubarrays(nums)}")
    }

}

fun continuousSubarrays(nums: IntArray): Long {
    val maxQ: Deque<Int> = ArrayDeque()
    val minQ: Deque<Int> = ArrayDeque()
    var left = 0
    var count: Long = 0

    for (right in nums.indices) {
        while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right]) {
            maxQ.pollLast()
        }
        maxQ.offerLast(right)

        while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right]) {
            minQ.pollLast()
        }
        minQ.offerLast(right)

        while (!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2
        ) {
            if (maxQ.peekFirst() < minQ.peekFirst()) {
                left = maxQ.peekFirst() + 1
                maxQ.pollFirst()
            } else {
                left = minQ.peekFirst() + 1
                minQ.pollFirst()
            }
        }

        count += (right - left + 1).toLong()
    }
    return count
}

fun continuousSubarrays1(nums: IntArray): Long {
    var left = 0
    var right = 0
    var count: Long = 0 // Total count of valid subarrays

    // Min and max heaps storing indices, sorted by nums[index] values
    val minHeap = PriorityQueue { a: Int?, b: Int? -> nums[a!!] - nums[b!!] }
    val maxHeap = PriorityQueue { a: Int?, b: Int? -> nums[b!!] - nums[a!!] }

    while (right < nums.size) {
        // Add current index to both heaps
        minHeap.add(right)
        maxHeap.add(right)

        // While window violates |nums[i] - nums[j]| ≤ 2 condition
        // Shrink window from left and remove outdated indices
        while (left < right && nums[maxHeap.peek()!!] - nums[minHeap.peek()!!] > 2
        ) {
            left++

            // Remove indices that are now outside window
            while (!maxHeap.isEmpty() && maxHeap.peek()!! < left) {
                maxHeap.poll()
            }
            while (!minHeap.isEmpty() && minHeap.peek()!! < left) {
                minHeap.poll()
            }
        }

        // Add count of all valid subarrays ending at right
        count += (right - left + 1).toLong()
        right++
    }

    return count
}
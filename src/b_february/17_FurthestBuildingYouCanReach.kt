package b_february

import java.util.*

/**
 *  Problem 17. Furthest Building You Can Reach
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

    val heights = intArrayOf(1, 5, 1, 2, 3, 4, 10000)
    val bricks = 4
    val ladders = 1

    val result = furthestBuilding(heights, bricks, ladders)

    println("Result ==> $result")

}

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    // Maximize heights for efficient brick usage
    val minHeap = PriorityQueue<Int> { a, b -> b - a }
    var L = ladders
    var B = bricks

    for (i in 1..<heights.size) {
        val diff = heights[i] - heights[i - 1]
        if (diff <= 0) continue

        B -= diff
        minHeap.offer(diff)
        if (B < 0) {
            if (L == 0) return i - 1

            L -= 1
            B += minHeap.poll()
        }

    }

    return heights.size - 1
}

fun furthestBuilding2(heights: IntArray, bricks: Int, ladders: Int): Int {
    val pq = PriorityQueue(Collections.reverseOrder<Int>())

    var curBricks = bricks
    var curLadders = ladders
    for (i in 0..<heights.lastIndex) {
        val jump = heights[i + 1] - heights[i]

        if (jump <= 0) continue

        curBricks -= jump
        pq.add(jump)
        if (curBricks < 0) {
            curBricks += pq.poll()
            if (curLadders > 0) curLadders-- else return i
        }
    }

    return heights.lastIndex
}
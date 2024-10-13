package j_october

import java.util.*
import kotlin.math.max


/**
 *  Problem 13. Smallest Range Covering Elements from K Lists
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(k * n)
 *
 *       - Space complexity: O(k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(
            listOf(4, 10, 15, 24, 26),
            listOf(0, 9, 12, 20),
            listOf(5, 18, 22, 30)
        )
    )

    testCases.forEach { nums ->
        println("Result ==> ${smallestRange(nums).toList()}")
    }

}

fun smallestRange(nums: List<List<Int>>): IntArray {
    val pq = PriorityQueue(
        Comparator.comparingInt { a: IntArray -> a[0] }
    )
    var maxVal = Int.MIN_VALUE
    var rangeStart = 0
    var rangeEnd = Int.MAX_VALUE
    for (i in nums.indices) {
        pq.offer(intArrayOf(nums[i][0], i, 0))
        maxVal = maxVal.coerceAtLeast(nums[i][0])
    }

    while (pq.size == nums.size) {
        val data = pq.poll()
        val minVal = data[0]
        val row = data[1]
        val col = data[2]

        if (maxVal - minVal < rangeEnd - rangeStart) {
            rangeStart = minVal
            rangeEnd = maxVal
        }

        if (col + 1 < nums[row].size) {
            val nextVal = nums[row][col + 1]
            pq.offer(intArrayOf(nextVal, row, col + 1))
            maxVal = max(maxVal.toDouble(), nextVal.toDouble()).toInt()
        }
    }

    return intArrayOf(rangeStart, rangeEnd)
}


// Brute force -
// TC - O(k * n) :: SC - O(k)
fun smallestRange1(nums: List<List<Int>>): IntArray {
    val k = nums.size

    val indices = IntArray(k)
    val range = intArrayOf(0, Int.MAX_VALUE)

    while (true) {
        var currMin = Int.MAX_VALUE
        var currMax = Int.MIN_VALUE
        var minInd = 0

        for (i in 0..<k) {
            val currNum = nums[i][indices[i]]
            if (currNum < currMin) {
                currMin = currNum
                minInd = i
            }

            if (currNum > currMax) {
                currMax = currNum
            }
        }

        if ((currMax - currMin) < (range[1] - range[0])) {
            range[0] = currMin
            range[1] = currMax
        }

        indices[minInd]++
        if (indices[minInd] == nums[minInd].size) break
    }

    return range
}
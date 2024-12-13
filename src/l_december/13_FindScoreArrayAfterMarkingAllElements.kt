package l_december

import java.util.*


/**
 *  Problem 13. Find Score of an Array After Marking All Elements.
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
        intArrayOf(2, 1, 3, 4, 5, 2),
        intArrayOf(2, 3, 5, 1, 3, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${findScore(nums)}")
    }

}

fun findScore(nums: IntArray): Long {
    var ans: Long = 0
    val marked = BooleanArray(nums.size)

    val heap = PriorityQueue { arr1: IntArray, arr2: IntArray ->
        if (arr1[0] != arr2[0]) (arr1[0] - arr2[0]) else arr1[1] - arr2[1]
    }

    for (i in nums.indices) {
        heap.add(intArrayOf(nums[i], i))
    }

    while (heap.isNotEmpty()) {
        val element = heap.remove()
        val number = element[0]
        val index = element[1]
        if (!marked[index]) {
            ans += number.toLong()
            marked[index] = true
            if (index - 1 >= 0) {
                marked[index - 1] = true
            }
            if (index + 1 < nums.size) {
                marked[index + 1] = true
            }
        }
    }

    return ans
}
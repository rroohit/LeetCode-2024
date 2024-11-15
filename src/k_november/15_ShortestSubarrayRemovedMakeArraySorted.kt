package k_november

import kotlin.math.min

/**
 *  Problem 15. Shortest Subarray to be Removed to Make Array Sorted.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3, 10, 4, 2, 3, 5),
        intArrayOf(5, 4, 3, 2, 1),
        intArrayOf(1, 2, 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${findLengthOfShortestSubarray(test)}")
    }

}

fun findLengthOfShortestSubarray(arr: IntArray): Int {
    var right: Int = arr.size - 1
    while (right > 0 && arr[right] >= arr[right - 1]) {
        right--
    }

    var ans = right
    var left = 0
    while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
        while (right < arr.size && arr[left] > arr[right]) {
            right++
        }
        ans = min(ans.toDouble(), (right - left - 1).toDouble()).toInt()
        left++
    }
    return ans
}
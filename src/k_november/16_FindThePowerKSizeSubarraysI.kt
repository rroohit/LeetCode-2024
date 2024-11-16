package k_november

/**
 *  Problem 16. Find the Power of K-Size Subarrays I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * k)
 *
 *       - Space complexity: O(n - k + 1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3, 4, 3, 2, 5), 3
        ),
        Pair(
            intArrayOf(2, 2, 2, 2, 2), 4
        ),
        Pair(
            intArrayOf(3, 2, 3, 2, 3, 2), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${resultsArray(test.first, test.second).toList()}")
    }

}

fun resultsArray(nums: IntArray, k: Int): IntArray {
    val length: Int = nums.size
    val result = IntArray(length - k + 1)

    for (start in 0..(length - k)) {
        var isConsecutiveAndSorted = true

        for (index in start..<start + k - 1) {
            if (nums[index + 1] != nums[index] + 1) {
                isConsecutiveAndSorted = false
                break
            }
        }

        if (isConsecutiveAndSorted) {
            result[start] = nums[start + k - 1]
        } else {
            result[start] = -1
        }
    }

    return result
}
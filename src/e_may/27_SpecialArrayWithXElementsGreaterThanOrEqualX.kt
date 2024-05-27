package e_may

/**
 *  Problem 27. Special Array With X Elements Greater Than or Equal X
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(0, 4, 3, 0, 4),
        intArrayOf(0, 0),
        intArrayOf(3, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${specialArray(nums)}")
    }

}

fun specialArray(nums: IntArray): Int {
    nums.sort()
    val freqCount = IntArray(nums.size + 1)
    for (n in nums) {
        if (n < nums.size) freqCount[n] += 1 else freqCount[nums.size] += 1
    }

    var totalCnt = 0
    for (r in nums.size downTo 0) {
        totalCnt += freqCount[r]
        if (totalCnt == r) return r
    }

    return -1
}
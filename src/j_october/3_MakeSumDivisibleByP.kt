package j_october

/**
 *  Problem 3. Make Sum Divisible by P
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(3, 1, 4, 2), 6
        ), Pair(
            intArrayOf(6, 3, 5, 2), 9
        ), Pair(
            intArrayOf(1, 2, 3), 3
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minSubarray(test.first, test.second)}")
    }

}

fun minSubarray(nums: IntArray, p: Int): Int {
    val n = nums.size
    val prefix = LongArray(n + 1) { 0 }
    for (i in nums.indices) {
        prefix[i + 1] = prefix[i] + nums[i]
    }
    val required = prefix[n] % p
    if (required.toInt() == 0) return 0

    for (windowSize in 1..<n) {
        var j = 0
        while (j + windowSize - 1 < n) {
            if ((prefix[j + windowSize] - prefix[j]) % p == required) return windowSize
            j++
        }
    }
    return -1
}
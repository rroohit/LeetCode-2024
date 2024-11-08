package k_november

/**
 *  Problem 8. Maximum XOR for Each Query.
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

    val testCases = listOf(
        Pair(
            intArrayOf(0, 1, 1, 3),
            2
        ),
        Pair(
            intArrayOf(2, 3, 4, 7),
            3
        ),
        Pair(
            intArrayOf(0, 1, 2, 2, 5, 7),
            3
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${getMaximumXor(test.first, test.second).toList()}")
    }

}

fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
    val prefixXOR = IntArray(nums.size)
    prefixXOR[0] = nums[0]
    for (i in 1..<nums.size) {
        prefixXOR[i] = prefixXOR[i - 1] xor nums[i]
    }
    val ans = IntArray(nums.size)

    val mask = (1 shl maximumBit) - 1

    for (i in nums.indices) {
        val currentXOR = prefixXOR[prefixXOR.size - 1 - i]
        ans[i] = currentXOR xor mask
    }

    return ans
}
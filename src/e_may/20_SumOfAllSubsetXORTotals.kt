package e_may

/**
 *  Problem 20. Sum of All Subset XOR Totals
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
        intArrayOf(1, 3),
        intArrayOf(5, 1, 6),
        intArrayOf(3, 4, 5, 6, 7, 8)
    )

    testCases.forEach { nums ->
        println("Result ==> ${subsetXORSum(nums)}")
    }

}

fun subsetXORSum(nums: IntArray): Int {
    return dfs(0, nums, 0)
}

private fun dfs(i: Int, nums: IntArray, total: Int): Int {
    if (i == nums.size) return total // base case
    return dfs(i + 1, nums, total xor nums[i]) + dfs(i + 1, nums, total)
}
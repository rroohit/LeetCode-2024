package l_december

/**
 *  Problem 26. Target Sum.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {
    val solutionTargetSum = SolutionTargetSum()

    val testCases = listOf(
        Pair(
            intArrayOf(1, 1, 1, 1, 1), 3
        ),
        Pair(intArrayOf(1), 1)
    )

    testCases.forEach { test ->
        println("Result ==> ${solutionTargetSum.findTargetSumWays(test.first, test.second)}")
    }

}

class SolutionTargetSum {

    // Recursion with memoization
    // TC - O(n * totalSum)
    // SC - O(n * totalSum)
    private var totalSum = 0
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        totalSum = nums.sum()
        val memo = Array(nums.size) { IntArray(2 * totalSum + 1) { Int.MIN_VALUE } }
        return calculateWays(nums, 0, 0, target, memo)
    }

    private fun calculateWays(
        nums: IntArray,
        ind: Int, // current index
        sum: Int, // current Sum
        target: Int,
        memo: Array<IntArray>
    ): Int {
        if (ind == nums.size) return if (sum == target) 1 else 0

        if (memo[ind][sum + totalSum] != Int.MIN_VALUE) return memo[ind][sum + totalSum]

        val add = calculateWays(
            nums,
            ind + 1,
            sum + nums[ind],
            target, memo
        )

        val subtract = calculateWays(
            nums,
            ind + 1,
            sum - nums[ind],
            target, memo
        )

        memo[ind][sum + totalSum] = add + subtract
        return memo[ind][sum + totalSum]
    }

    // Brute Force - (recursion)
    // TC - O(2^n)
    // SC - O(n)
    private var totalWays = 0
    @Suppress("unused")
    fun findTargetSumWays1(nums: IntArray, target: Int): Int {
        totalWays = 0
        calculateWays(nums, target, 0, 0)
        return totalWays
    }

    private fun calculateWays(nums: IntArray, target: Int, sum: Int, i: Int) {
        if (i == nums.size) {
            if (sum == target) totalWays++
        } else {
            // positive sign
            calculateWays(nums, target, sum + nums[i], i + 1)
            // negative sign
            calculateWays(nums, target, sum - nums[i], i + 1)
        }
    }

}

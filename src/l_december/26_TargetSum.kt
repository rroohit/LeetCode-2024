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

    // Brute Force - (recursion)
    // TC - O(2^n)
    // SC - O(n)
    private var totalWays = 0
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
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

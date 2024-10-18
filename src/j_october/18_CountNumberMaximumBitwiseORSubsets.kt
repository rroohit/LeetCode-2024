package j_october

/**
 *  Problem 18. Count Number of Maximum Bitwise-OR Subsets
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(2^N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(3, 1),
        intArrayOf(2, 2, 2),
        intArrayOf(3, 2, 1, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countMaxOrSubsets(nums)}")
    }

}

fun countMaxOrSubsets(nums: IntArray): Int {
    var maxOr = 0
    for (num in nums) maxOr = maxOr or num
    val memo = Array(nums.size) { arrayOfNulls<Int>(maxOr + 1) }
    return countSubset(nums, 0, 0, maxOr, memo)
}

// memoization + recursion :: TC - O(n * maxOr) :: SC - O(n * maxOr)
private fun countSubset(nums: IntArray, i: Int, currOr: Int, targetOr: Int, memo: Array<Array<Int?>>): Int {
    if (i == nums.size) {
        return if (currOr == targetOr) 1 else 0
    }

    if (memo[i][currOr] != null) return memo[i][currOr]!!

    memo[i][currOr] = countSubset(nums, i + 1, currOr, targetOr, memo) +
            countSubset(nums, i + 1, currOr or nums[i], targetOr, memo)
    return memo[i][currOr]!!
}

////////////////////////////////////
// 1
// recursion TC - O(2^n) :: SC - O(N)
private fun countSubset1(nums: IntArray, i: Int, currOr: Int, targetOr: Int): Int {
    return if (i == nums.size) {
        if (currOr == targetOr) 1 else 0
    } else {
        countSubset1(nums, i + 1, currOr, targetOr) +
                countSubset1(nums, i + 1, currOr or nums[i], targetOr)
    }
}
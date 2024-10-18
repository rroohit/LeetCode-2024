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
    for (num in nums) {
        maxOr = maxOr or num
    }
    return countSubset(nums, 0, 0, maxOr)
}

private fun countSubset(nums: IntArray, i: Int, currOr: Int, targetOr: Int): Int {
    return if (i == nums.size) {
        if (currOr == targetOr) 1 else 0
    } else {
        countSubset(nums, i + 1, currOr, targetOr) +
                countSubset(nums, i + 1, currOr or nums[i], targetOr)
    }
}
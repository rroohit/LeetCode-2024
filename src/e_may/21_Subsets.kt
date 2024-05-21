package e_may

/**
 *  Problem 21. Subsets
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * 2^n)
 *
 *       - Space complexity: O(n * 2^n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0)
    )

    testCases.forEach { nums ->
        println("Result => ${subsets(nums)}")
    }

}

private val subsetList = mutableListOf<List<Int>>()
fun subsets(nums: IntArray): List<List<Int>> {
    subsetList.clear()
    getAllSubsets(0, nums, mutableListOf())
    return subsetList
}

private fun getAllSubsets(curIndex: Int, nums: IntArray, list: MutableList<Int>, ) {
    // base case
    if (curIndex == nums.size) {
        subsetList.add(list.toList())
        return
    }

    // include current num
    list.add(nums[curIndex])
    // build list with remaining nums
    getAllSubsets(curIndex + 1, nums, list)

    // Backtracking exclude current num
    list.removeLastOrNull()
    // build list with remaining nums
    getAllSubsets(curIndex + 1, nums, list)
}
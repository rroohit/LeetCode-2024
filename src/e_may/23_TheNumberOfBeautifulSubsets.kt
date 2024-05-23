package e_may

/**
 *  Problem 23. The Number of Beautiful Subsets
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
        Pair(2, intArrayOf(2, 4, 6))
    )

    testCases.forEach { test ->
        println("Result ==> ${beautifulSubsets(test.second, test.first)}")
    }

}

fun beautifulSubsets(nums: IntArray, k: Int): Int {
    val cntSeen = HashMap<Int, Int>()
    return dfsCountSubsets(0, nums, k, cntSeen) - 1
}

private fun dfsCountSubsets(i: Int, nums: IntArray, k:Int, cntSeen: HashMap<Int, Int>): Int {
    // Base Case
    if (i == nums.size) {
        return 1
    }
    /// Exclude current num
    var cnt = dfsCountSubsets(i + 1, nums, k, cntSeen)

    /// Include if abs diff won't match with k
    val left = nums[i] - k
    val right = nums[i] + k
    if(!cntSeen.containsKey(left) && !cntSeen.containsKey(right)) {
        cntSeen[nums[i]] = cntSeen.getOrDefault(nums[i], 0) + 1
        cnt += dfsCountSubsets(i + 1, nums, k, cntSeen)
        // Backtracking
        cntSeen[nums[i]] = cntSeen.getOrDefault(nums[i], 1) - 1
        if (cntSeen[nums[i]] == 0) {
            cntSeen.remove(nums[i])
        }
    }

    return cnt
}
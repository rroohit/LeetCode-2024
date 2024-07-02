package g_july

/**
 *  Problem 2. Intersection of Two Arrays II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m + n)
 *
 *       - Space complexity: O(min(m, n))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 2, 1),
            intArrayOf(2, 2)
        ),
        Pair(
            intArrayOf(9, 4, 9, 8, 4),
            intArrayOf(4, 9, 5)
        )
    )

    for (testCase in testCases) {
        println("Result ==> ${intersect(testCase.first, testCase.second).toList()}")
    }

}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val cntMap = HashMap<Int, Int>()
    for (num in nums1) {
        cntMap[num] = cntMap.getOrDefault(num, 0) + 1
    }

    val result = mutableListOf<Int>()
    for (num in nums2) {
        val cnt = cntMap.getOrDefault(num, 0)
        if (cnt > 0) result.add(num)
        cntMap[num] = cnt - 1
    }

    return result.toIntArray()
}
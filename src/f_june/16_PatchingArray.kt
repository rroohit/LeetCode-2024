package f_june

/**
 *  Problem 16. Patching Array
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
        Pair(intArrayOf(1, 3), 6)
    )

    testCases.forEach { test ->
        println("Result ==> ${minPatches(test.first, test.second)}")
    }

}

fun minPatches(nums: IntArray, n: Int): Int {
    var miss: Long = 1
    var result = 0
    var i = 0

    while (miss <= n) {
        if (i < nums.size && nums[i].toLong() <= miss) {
            miss += nums[i]
            i++
        } else {
            miss += miss
            result++
        }
    }

    return result
}
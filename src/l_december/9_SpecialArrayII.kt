package l_december


/**
 *  Problem 9. Special Array II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m + n)
 *
 *       - Space complexity: O(m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(3, 4, 1, 2, 6),
            arrayOf(intArrayOf(0, 4))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${isArraySpecial(test.first, test.second).toList()}")
    }

}


fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val ans = BooleanArray(queries.size)
    val prefix = IntArray(nums.size)
    prefix[0] = 0

    for (i in 1..<nums.size) {
        if (nums[i] % 2 == nums[i - 1] % 2) {
            prefix[i] = prefix[i - 1] + 1
        } else {
            prefix[i] = prefix[i - 1]
        }
    }

    for (i in queries.indices) {
        val query = queries[i]
        val start = query[0]
        val end = query[1]

        ans[i] = prefix[end] - prefix[start] == 0
    }

    return ans
}

fun isArraySpecial2(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val ans = BooleanArray(queries.size)
    val violatingIndices = ArrayList<Int>()

    for (i in 1..<nums.size) {
        if (nums[i] % 2 == nums[i - 1] % 2) {
            violatingIndices.add(i)
        }
    }

    for (i in queries.indices) {
        val query = queries[i]
        val start = query[0]
        val end = query[1]

        val foundViolatingIndex = binarySearch(
            start + 1,
            end,
            violatingIndices
        )

        ans[i] = !foundViolatingIndex
    }

    return ans
}

private fun binarySearch(
    start: Int,
    end: Int,
    violatingIndices: ArrayList<Int>
): Boolean {
    var left = 0
    var right = violatingIndices.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val violatingIndex = violatingIndices[mid]
        if (violatingIndex < start) {
            // check right half
            left = mid + 1
        } else if (violatingIndex > end) {
            // check left half
            right = mid - 1
        } else {
            return true
        }
    }
    return false
}
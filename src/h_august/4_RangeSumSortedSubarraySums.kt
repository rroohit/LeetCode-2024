package h_august

import java.util.*

/**
 *  Problem 4. Range Sum of Sorted Subarray Sums
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

    val testCases = listOf(
        TestData(
            nums = intArrayOf(1, 2, 3, 4),
            n = 4,
            left = 1,
            right = 5
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${rangeSum(test.nums, test.n, test.left, test.right)}")
    }

}

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val mod = 1_000_000_007
    val sums = mutableListOf<Long>()

    return 0
}

private data class TestData(
    val nums: IntArray,
    val n: Int,
    val left: Int,
    val right: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData

        if (!nums.contentEquals(other.nums)) return false
        if (n != other.n) return false
        if (left != other.left) return false
        if (right != other.right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nums.contentHashCode()
        result = 31 * result + n
        result = 31 * result + left
        result = 31 * result + right
        return result
    }
}

fun rangeSum1(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val pqDesc = PriorityQueue<Int> { a, b -> b - a }
    val mod = 1_000_000_007
    var rez = 0
    for (i in 0..<n) {
        var sum = 0
        for (j in i..<n) {
            sum += nums[j]
            pqDesc.add(sum)
            if (pqDesc.size > right) pqDesc.poll()
        }
    }
    for (i in left..right) {
        rez = (rez + pqDesc.poll()) % mod
    }
    return rez
}
package h_august

import java.util.*

/**
 *  Problem 12. Kth Largest Element in a Stream
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(Log k)
 *
 *       - Space complexity: O(K)
 *
 * ## Code -
 */
fun main() {

     val testCases = listOf(
         TestDataQu(
             3,
             intArrayOf(4, 5, 8, 2),
             intArrayOf(3, 5, 10, 9, 4)
         )
     )

    testCases.forEach { testDataQu ->
        val kthLargest = KthLargest(testDataQu.k, testDataQu.nums)
        testDataQu.numsToAdd.forEach { num ->
            println("Result ==> ${kthLargest.add(num)}")
        }
    }

}

class KthLargest(k: Int, nums: IntArray) {
    private val k = k
    private val prQu = PriorityQueue<Int>()
    init {
        nums.forEach { add(it) }
    }
    fun add(`val`: Int): Int {
        prQu.add(`val`)
        if (prQu.size > k) prQu.remove()
        return prQu.peek()!!
    }
}

private data class TestDataQu(
    val k: Int,
    val nums: IntArray,
    val numsToAdd: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestDataQu

        if (k != other.k) return false
        if (!nums.contentEquals(other.nums)) return false
        if (!numsToAdd.contentEquals(other.numsToAdd)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = k
        result = 31 * result + nums.contentHashCode()
        result = 31 * result + numsToAdd.contentHashCode()
        return result
    }
}
package k_november

import kotlin.math.sqrt

/**
 *  Problem 11. Prime Subtraction Operation.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * Sqrt(Max(Nums[I])))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(4, 9, 6, 10),
        intArrayOf(6, 8, 11, 12),
        intArrayOf(5, 8, 3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${primeSubOperation(nums)}")
    }

}

fun primeSubOperation(nums: IntArray): Boolean {
    for (i in nums.indices) {
        val bound = if (i == 0) {
            nums[0]
        } else {
            nums[i] - nums[i - 1]
        }

        if (bound <= 0) {
            return false
        }

        var largestPrime = 0
        for (j in bound - 1 downTo 2) {
            if (checkPrime(j)) {
                largestPrime = j
                break
            }
        }
        nums[i] = nums[i] - largestPrime
    }
    return true
}

fun checkPrime(x: Int): Boolean {
    var i = 2
    while (i <= sqrt(x.toDouble())) {
        if (x % i == 0) {
            return false
        }
        i++
    }
    return true
}
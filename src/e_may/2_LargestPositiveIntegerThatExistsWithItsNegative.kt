package e_may

import kotlin.math.abs
import kotlin.math.max

/**
 *  Problem 2. Largest Positive Integer That Exists With Its Negative
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
        intArrayOf(-1, 2, -3, 3),
        intArrayOf(-1, 10, 6, 7, -7, 1),
        intArrayOf(-10, 8, 6, 7, -2, -3)
    )

    testCases.forEach { nums ->
        println("Result ==> ${findMaxK(nums)}")
    }

}

// Using sorting :: TC - best - O(log n) : worst - O(n) :: SC - O(n) - for sorting..
fun findMaxK(nums: IntArray): Int {
    nums.sort() // TC - O(log n) best :: worst - O(n)
    var l = 0
    var r = nums.size - 1
    while (l < r) { // TC - O(n)
        if (nums[l] > 0) break // No more negative nums
        if (nums[l] + nums[r] == 0) return abs(nums[l])

        if (nums[r] > abs(nums[l])) r-- else l++
    }

    return -1
}

// Using extra space : TC - O(n) :: SC  - O(n)
fun findMaxK1(nums: IntArray): Int {
    val seen = HashSet<Int>() // SC - O(n)
    var maxNum = -1
    for (num in nums) { // TC - O(n)
        if (seen.contains(-num)){
            maxNum = max(maxNum, abs(num))
        }
        seen.add(num)
    }
    return maxNum
}


// Brute force :: TC - O(n^2) :: SC - O(n)
fun findMaxK2(nums: IntArray): Int {
    var maxNum = -1
    for (i in nums.indices) { // TC - O(n)
        for (j in i + 1 ..< nums.size) { // TC - O(n)
            if (nums[i] + nums[j] == 0) {
                maxNum = max(maxNum, abs(nums[i]))
            }
        }
    }

    return maxNum
}
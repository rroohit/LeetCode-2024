package j_october

import kotlin.math.max

/**
 *  Problem 28. Longest Square Streak in an Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(4, 3, 6, 16, 8, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${longestSquareStreak(nums)}")
    }

}

fun longestSquareStreak(nums: IntArray): Int {
    nums.sort()
    val seenNum = HashSet<Int>()
    var longStreak = 0

    for (num in nums) {
        if (seenNum.contains(num)) continue
        var streak: Int = num
        var streakLength = 1

        while (true) {
            if (streak.toLong() * streak.toLong() > 1e5) break
            if (binarySearch(nums, streak * streak)) {
                streak *= streak
                seenNum.add(streak)
                streakLength++
            } else break

        }
        longStreak = max(longStreak, streakLength)

    }

    return if (longStreak < 2) -1 else longStreak
}

private fun binarySearch(nums: IntArray, target: Int): Boolean {
    if (target < 0) return false
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return true
        if (nums[mid] > target) right = mid - 1 else left = mid + 1
    }
    return false
}
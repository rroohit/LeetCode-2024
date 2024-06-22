package f_june

/**
 *  Problem 22. Count Number of Nice Subarrays
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
        Pair(intArrayOf(1, 1, 2, 1, 1), 3),
        Pair(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2),
    )

    testCases.forEach { test ->
        println("Result ==> ${numberOfSubarrays(test.first, test.second)}")
    }

}

fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var odd = 0
    var count = 0
    var l = 0
    var m = 0

    for (r in nums.indices) {
        odd += nums[r] and 1

        while (odd > k) {
            odd -= nums[l] and 1
            l++
            m = l
        }

        if (odd == k) {
            while (nums[m] and 1 == 0) m++
            count += (m - l) + 1
        }

    }

    return count
}

fun numberOfSubarrays2(nums: IntArray, k: Int): Int {
    val counts = mutableMapOf<Int, Int>()

    var curr = 0
    var ans = 0
    counts[0] = 1

    for (num in nums) {
        curr += num % 2

        ans += counts.getOrDefault(curr - k, 0)

        counts[curr] = counts.getOrDefault(curr, 0) + 1
    }

    return ans
}
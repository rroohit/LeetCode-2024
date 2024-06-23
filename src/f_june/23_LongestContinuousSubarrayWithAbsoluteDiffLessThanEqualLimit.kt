package f_june

// Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(8, 2, 4, 7), 4),
        Pair(intArrayOf(4, 2, 2, 2, 4, 4, 2, 2), 0)
    )

    testCases.forEach { test ->
        println("Result ==> ${longestSubarray(test.first, test.second)}")
    }

}

fun longestSubarray(nums: IntArray, limit: Int): Int {
    val maxList = mutableListOf<Int>()
    val minList = mutableListOf<Int>()

    var l = 0
    var ans = 0

    for (r in nums.indices) {
        while (maxList.isNotEmpty() && nums[r] > maxList.last()) {
            maxList.removeLast()
        }
        maxList.add(nums[r])

        while (minList.isNotEmpty() && nums[r] < minList.last()) {
            minList.removeLast()
        }
        minList.add(nums[r])

        while (maxList.first() - minList.first() > limit) {
            if (maxList.first() == nums[l]) {
                maxList.removeFirst()
            }
            if (minList.first() == nums[l]) {
                minList.removeFirst()
            }
            l++
        }

        ans = maxOf(ans, r - l + 1)
    }

    return ans
}

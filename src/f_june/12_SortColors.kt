package f_june

/**
 *  Problem 12. Sort Colors
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
        intArrayOf(2, 0, 2, 1, 1, 0),
        intArrayOf(1, 0, 0)
    )

    testCases.forEach { nums ->
        sortColors(nums)
        println("Result ==> ${nums.toList()}")
    }

}

fun sortColors(nums: IntArray): Unit {
    var red = 0
    var white = 0
    var blue = 0
    for (num in nums) {
        when (num) {
            0 -> red++
            1 -> white++
            2 -> blue++
        }
    }
    sortCol(nums, red, 0, 0)
    sortCol(nums, white, 1, red)
    sortCol(nums, blue, 2, red + white)
}

private fun sortCol(nums: IntArray, count: Int, num: Int, start: Int) {
    for (i in start..<(start + count)) nums[i] = num
}


fun sortColors2(nums: IntArray): Unit {
    var l = 0
    var r = nums.size - 1

    while (l < r) {
        while (l < r && nums[l] == 0) l++

        while (r > l && nums[r] != 0) r--

        if (nums[l] != 0 && nums[r] == 0) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
        }
    }

    r = nums.size - 1
    while (l < r) {
        while (l < r && nums[l] == 1) l++

        while (r > l && nums[r] != 1) r--

        if (nums[l] != 1 && nums[r] == 1) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
        }
    }
}
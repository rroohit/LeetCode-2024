package b_february

/**
 *  Problem = 15. Find Polygon With the Largest Perimeter
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

    val nums = intArrayOf(1, 12, 1, 2, 5, 50, 3)

    val result = largestPerimeter(nums)

    println("Result ==> $result")

}

fun largestPerimeter(nums: IntArray): Long {
    nums.sort()
    var pref = (nums[0] + nums[1]).toLong()
    var ans = -1L

    for ((i, num) in nums.withIndex()) {
        if(i <= 1) continue
        if (pref > num) {
            ans = pref + num
        }
        pref += num
    }

    return ans
}
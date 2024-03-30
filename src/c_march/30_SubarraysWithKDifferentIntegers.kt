package c_march

/**
 *  Problem 30. Subarrays with K Different Integers
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val nums = intArrayOf(1, 2, 1, 2, 3)
    val k = 2

    println("Result ==> ${subarraysWithKDistinct(nums, k)}")

}

// TC - O(n) : SC - O(n)
fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    val count = HashMap<Int, Int>()
    var res = 0
    var lFar = 0
    var lNear = 0

    for (r in nums.indices) {
        count[nums[r]] = count.getOrDefault(nums[r], 0) + 1

        // when we exceed the k distinct element size in window
        while (count.size > k) {
            count[nums[lNear]] = count[nums[lNear]]!! - 1
            if (count[nums[lNear]] == 0) {
                count.remove(nums[lNear])
            }
            lNear += 1
            lFar = lNear
        }

        while (count[nums[lNear]]!! > 1){
            count[nums[lNear]] = count[nums[lNear]]!! - 1
            lNear++
        }

        if (count.size == k) {
            res += lNear - lFar + 1
        }

    }

    return res
}














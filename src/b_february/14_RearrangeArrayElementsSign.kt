package b_february

/**
 *  Problem = 14. Rearrange Array Elements by Sign
 *
 *  ## Intuition -
 *      - The values in array equal length of positive and negative so whenever we see negative or positive value we just an index
 *          where we can add that value
 *
 *
 *  ## Approach -
 *      - Will keep positive-p at 0-index and negative-n at 1 index (as given array size is always >= 2)
 *      - These are the index where we update positive or negative value in ans.
 *      - While iterating through given array based on the value we update it at index like at p or n and move that pointer by +2 index.
 *      - Will continue this until we complete the traveling the given array
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n) if res consider or O(1)
 *
 * ## Code -
 */
fun main() {

    val nums = intArrayOf(3, 1, -2, -5, 2, -4)

    val result = rearrangeArray(nums)

    println("Result ==> ${result.toList()}")

}

fun rearrangeArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var p = 0 // positive pointer
    var n = 1 // negative pointer

    for (num in nums){
        if (num < 0) {
            ans[n++] = num
            n++
        } else {
            ans[p++] = num
            p++
        }
    }

    return ans
}
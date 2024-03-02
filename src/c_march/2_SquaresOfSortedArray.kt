package c_march

/**
 *  Problem 2. Squares of a Sorted Array
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val nums = intArrayOf(-4, -1, 0, 3, 10)

    println("Result => ${sortedSquares(nums).toList()}")

}

fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 0 }
    var p = 0
    nums.forEach {
        result[p++] = it * it
    }
    result.sort()
    return result
}

fun sortedSquares2(nums: IntArray): IntArray {
    val result = IntArray(nums.size) { 0 }
    var p = 0
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val left = nums[l] * nums[l]
        val right = nums[r] * nums[r]
        if (left > right) {
            result[p] = right
            r--
        } else {
            result[p] = left
            l++
        }
        p++
    }
    return result
}
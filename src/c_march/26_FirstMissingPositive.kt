package c_march

/**
 *  Problem 26. First Missing Positive
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

    val nums = intArrayOf(1, 2, 7, 8, 9, 11, 12)

    println("Result ==> ${firstMissingPositive(nums)}")

}

// TC - O(n) : SC - O(n)
fun firstMissingPositive(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (num in nums) {
        set.add(num)
    }

    var k = 1
    while (true) {
        if (!set.contains(k)) break
        k++
    }
    return k
}










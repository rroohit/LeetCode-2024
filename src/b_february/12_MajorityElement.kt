package b_february

/**
 *  Problem = 12 : Majority Element
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

    val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)

    val result = majorityElement(nums)

    println("Result => $result")

}

// TC - O(n) : SC - O(1)
fun majorityElement(nums: IntArray): Int {
    var curr = 0
    var count = 0
    for (num in nums) {
        if (count == 0) curr = num
        if (num == curr) count++ else count--
    }
    return curr
}

// TC - O(n) : SC - O(n)
fun majorityElement1(nums: IntArray): Int {
    val countMap = HashMap<Int, Int>()
    for (num in nums){
        val count = countMap.getOrDefault(num, 0)
        countMap[num] = count + 1
        if (count + 1 > nums.size / 2) return num
    }
    return -1
}








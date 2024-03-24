package c_march

/**
 *  Problem 24. Find the Duplicate Number
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

    val nums = intArrayOf(1, 3, 4, 2, 2)

    println("Result => ${findDuplicate(nums)}")

}

// TC - O(n) : SC = O(1) : Floyd's Algorithm
fun findDuplicate(nums: IntArray): Int {
    var slow = 0
    var fast = 0
    while (true) {
        slow = nums[slow]
        fast = nums[nums[fast]]
        if (slow == fast) break
    }

    var slw = 0
    while (true) {
        slow = nums[slow]
        slw = nums[slw]
        if (slow == slw) return slow
    }
}

// TC - O(n) : SC - O(n)
fun findDuplicate1(nums: IntArray): Int {
    val solArray = BooleanArray(size = nums.size) { false }
    for (num in nums) {
        if (solArray[num]) {
            return num
        } else {
            solArray[num] = true
        }
    }
    return -1
}

// TC - O(n) : SC - O(n)
fun findDuplicate2(nums: IntArray): Int {
    val set = HashSet<Int>()
    for (num in nums) {
        if (set.contains(num)) return num
        set.add(num)
    }

    return -1
}
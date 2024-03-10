package c_march

/**
 *  Problem 9. Minimum Common Value
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N) -
 *
 *       - Space complexity: O(N) - number of elements in nums1, in worst case each element is unique.
 *
 * ## Code -
 */
fun main() {

    val nums1 = intArrayOf(1, 2, 3, 6)
    val nums2 = intArrayOf(2, 3, 4, 5)

    println("Result ==> ${getCommon(nums1, nums2)}")

}


fun getCommon(nums1: IntArray, nums2: IntArray): Int {
    val map = HashMap<Int, Int>()

    for (num in nums1) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    for (num in nums2) {
        if (map.containsKey(num)) return num
    }

    return -1
}
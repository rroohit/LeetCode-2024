package c_march

/**
 *  Problem 10. Intersection of Two Arrays
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *          - n is no of elements in array one
 *          - m is no of elements in array two
 *
 *       - Space complexity: o(n)
 *          - n is no of elements in array one
 *              O(n + m) if we do consider the m as out put array.
 *
 * ## Code -
 */
fun main() {

    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)

    val result = intersection(nums1, nums2)

    println("Result ==> ${result.toList()}")

}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashSet<Int>()
    nums1.forEach { i ->
       map.add(i)
    }

    val result = HashSet<Int>()
    for (i in nums2) {
        if (map.contains(i)) result.add(i)
    }

    return result.toIntArray()
}
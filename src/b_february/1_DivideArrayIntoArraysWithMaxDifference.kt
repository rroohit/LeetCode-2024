package b_february

/**
 *  Problem = 1 : Divide Array Into Arrays With Max Difference
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val nums = intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1)
    val k = 2

    val result = divideArray(nums, k)

    result.forEach {
        println(it.toList())
    }

}

fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    val ans = mutableListOf<IntArray>()

    nums.sort()

    for (i in 2 ..< nums.size step 3) {
        if (nums[i] - nums[i - 2] <= k) {
            val arr = IntArray(3)
            for (j in i downTo i - 2) {
                arr[j % 3] = nums[j]
            }
            ans.add(arr)
        } else {
            return arrayOf()
        }
    }

    return ans.toTypedArray()
}
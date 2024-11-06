package k_november


/**
 *  Problem 6. Find if Array Can Be Sorted.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(8, 4, 2, 30, 15)
    )

    testCases.forEach { nums ->
        println("Result ==> ${canSortArray(nums)}")
    }

}

fun canSortArray(nums: IntArray): Boolean {
    val numsCopy = nums.copyOf()
    val n: Int = nums.size

    for (i in 0..<n) {
        for (j in 0..<n - i - 1) {
            if (numsCopy[j] <= numsCopy[j + 1]) {
                // No swap needed
                continue
            } else {
                if (Integer.bitCount(numsCopy[j]) ==
                    Integer.bitCount(numsCopy[j + 1])
                ) {
                    // Swap the elements
                    val temp: Int = numsCopy[j]
                    numsCopy[j] = numsCopy[j + 1]
                    numsCopy[j + 1] = temp
                } else {
                    return false
                }
            }
        }
    }
    return true
}
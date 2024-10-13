package j_october

/**
 *  Problem 13. Smallest Range Covering Elements from K Lists
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(k * n)
 *
 *       - Space complexity: O(k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(
            listOf(4, 10, 15, 24, 26),
            listOf(0, 9, 12, 20),
            listOf(5, 18, 22, 30)
        )
    )

    testCases.forEach { nums ->
        println("Result ==> ${smallestRange(nums).toList()}")
    }

}

// Brute force -
// TC - O(k * n) :: SC - O(k)
fun smallestRange(nums: List<List<Int>>): IntArray {
    val k = nums.size

    val indices = IntArray(k)
    val range = intArrayOf(0, Int.MAX_VALUE)

    while (true) {
        var currMin = Int.MAX_VALUE
        var currMax = Int.MIN_VALUE
        var minInd = 0

        for (i in 0..<k) {
            val currNum = nums[i][indices[i]]
            if (currNum < currMin) {
                currMin = currNum
                minInd = i
            }

            if (currNum > currMax) {
                currMax = currNum
            }
        }

        if ((currMax - currMin) < (range[1] - range[0])) {
            range[0] = currMin
            range[1] = currMax
        }

        indices[minInd]++
        if (indices[minInd] == nums[minInd].size) break
    }

    return range
}
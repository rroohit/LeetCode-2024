package g_july

/**
 *  Problem 24. Sort the Jumbled Numbers
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N logN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6),
            intArrayOf(991, 338, 38)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${sortJumbled(test.first, test.second).toList()}")
    }

}

fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
    val storePairs = mutableListOf<List<Int>>()
    for (i in nums.indices) {
        var mappedNum = 0
        var tempNum = nums[i]
        var place = 1
        if (tempNum == 0) mappedNum += mapping[0]
        while (tempNum > 0) {
            mappedNum += place * mapping[tempNum % 10]
            place *= 10
            tempNum /= 10
        }
        storePairs.add(listOf(mappedNum, i))
    }
    storePairs.sortBy { it[0] }

    val result = IntArray(nums.size)
    for (i in storePairs.indices) {
        result[i] = nums[storePairs[i][1]]
    }
    return result
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////
fun sortJumbled1(mapping: IntArray, nums: IntArray): IntArray {
    // Map each digit of a number to its mapped value according to 'mapping'
    fun remapNumber(num: Int): Int {
        var n = num
        var remappedValue = 0
        var place = 1
        if (n == 0) return mapping[0] // Special case for 0
        while (n > 0) {
            val digit = n % 10
            remappedValue += mapping[digit] * place
            place *= 10
            n /= 10
        }
        return remappedValue
    }

    // Pair each number with its remapped value for sorting
    val remappedPairs = nums.map { num -> Pair(num, remapNumber(num)) }

    // Sort by the remapped values
    val sortedPairs = remappedPairs.sortedBy { it.second }

    // Return the original numbers sorted according to their remapped values
    return sortedPairs.map { it.first }.toIntArray()
}
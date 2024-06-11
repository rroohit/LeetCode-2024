package f_june

/**
 *  Problem 11. Relative Sort Array
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n log n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), intArrayOf(2, 1, 4, 3, 9, 6)),
        Pair(
            intArrayOf(2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31),
            intArrayOf(2, 42, 38, 0, 43, 21)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${relativeSortArray(test.first, test.second).toList()}")
    }

}

fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    val cntMap = HashMap<Int, Int>() // SC - O(n)
    for (num in arr1) { // TC - O(n)
        cntMap[num] = cntMap.getOrDefault(num, 0) + 1
    }

    // val result = IntArray(arr1.size) // SC - O(n)
    var l = 0
    for (num in arr2) { // TC - O(n)
        repeat(cntMap[num]!!) {
            arr1[l++] = num
        }
        cntMap.remove(num)
    }

    val remain = cntMap.keys.sorted()
    for (num in remain) { // TC - O(n)
        repeat(cntMap[num]!!) {
            arr1[l++] = num
        }
    }

    return arr1
}
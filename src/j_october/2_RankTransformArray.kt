package j_october

import java.util.*


/**
 *  Problem 2. Rank Transform of an Array
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N LogN)
 *
 *       - Space complexity: O(N + S)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(40, 10, 20, 30),
        intArrayOf(100, 100, 100),
        intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)
    )

    testCases.forEach { arr ->
        println("Result ==> ${arrayRankTransform(arr).toList()}")
    }

}

fun arrayRankTransform(arr: IntArray): IntArray {
    val numToRank = HashMap<Int, Int>()
    val sortedArr = arr.copyOf()
    Arrays.sort(sortedArr)
    var rank = 1
    for (i in sortedArr.indices) {
        if (i > 0 && sortedArr[i] > sortedArr[i - 1]) {
            rank++
        }
        numToRank[sortedArr[i]] = rank
    }
    for (i in arr.indices) {
        arr[i] = numToRank[arr[i]]!!
    }
    return arr
}
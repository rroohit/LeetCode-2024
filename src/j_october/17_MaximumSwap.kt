package j_october

import kotlin.math.max

/**
 *  Problem 17. Maximum Swap
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        2736,
        9973,
        222229,
        98368
    )

    testCases.forEach { num ->
        println("Result $num ==> ${maximumSwap(num)}")
    }

}

fun maximumSwap(num: Int): Int {
    val numArr = num.toString().toCharArray()
    val n = numArr.size
    val maxRightIndex = IntArray(n)

    maxRightIndex[n - 1] = n - 1
    for (i in n - 2 downTo 0) {
        maxRightIndex[i] = if ((numArr[i] > numArr[maxRightIndex[i + 1]]))
            i
        else
            maxRightIndex[i + 1]
    }

    for (i in 0..<n) {
        if (numArr[i] < numArr[maxRightIndex[i]]) {
            val temp = numArr[i]
            numArr[i] = numArr[maxRightIndex[i]]
            numArr[maxRightIndex[i]] = temp
            return String(numArr).toInt()
        }
    }

    return num
}

// TC - O(N^2) :: SC - O(N)
fun maximumSwap1(num: Int): Int {
    val strNum = num.toString()
    val n = strNum.length
    var maxNum = num

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            val chars = strNum.toCharArray()
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp

            val newNum = StringBuilder().append(chars).toString().toInt()
            maxNum = max(maxNum, newNum)
        }
    }

    return maxNum
}
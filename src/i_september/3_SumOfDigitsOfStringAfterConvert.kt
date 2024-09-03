package i_september

/**
 *  Problem 3. Sum of Digits Of String After Convert
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("iiii", 1),
        Pair("leetcode", 2),
        Pair("zbax", 2)
    )

    testCases.forEach { test ->
        println("Result ==> ${getLucky(test.first, test.second)}")
    }

}

fun getLucky(s: String, k: Int): Int {
    var totalSum = 0
    for (ch in s) {
        var currNum = ch - 'a' + 1
        while (currNum > 0) {
            totalSum += (currNum % 10)
            currNum /= 10
        }
    }

    repeat(k - 1) {
        var currNum = totalSum
        totalSum = 0
        while (currNum > 0) {
            totalSum += currNum % 10
            currNum /= 10
        }
    }

    return totalSum
}
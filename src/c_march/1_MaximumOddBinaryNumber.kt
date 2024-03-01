package c_march

/**
 *  Problem 1. Maximum Odd Binary Number
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val s = "0101"

    println("Result ==> ${maximumOddBinaryNumber(s)}")

}

fun maximumOddBinaryNumber(s: String): String {
    val oneS = s.count { it == '1' }

    val reqZero = s.length - (oneS)
    var res = "0".repeat(reqZero) + "1"

    res = "1".repeat(oneS - 1) + res

    return res
}
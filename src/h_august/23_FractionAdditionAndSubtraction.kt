package h_august

import kotlin.math.abs

/**
 *  Problem 23. Fraction Addition and Subtraction
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(log(min(a, b)))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "-1/2+1/2",
        "-1/2+1/2+1/3",
        "1/3-1/2"
    )

    testCases.forEach { expression ->
        println("Result ==> ${fractionAddition(expression)}")
    }

}

// TC - O(N) :: SC - O(log(min(a,b)))
fun fractionAddition(expression: String): String {
    val n = expression.length
    var i = 0
    var numerator = 0
    var denominator = 1

    while (i < n) {
        // check for sign
        val isNegative = if (expression[i] == '-' || expression[i] == '+') {
            expression[i++] == '-'
        } else false

        var currNumerator = 0
        var currDenominator = 0

        // build Numerator
        while (i < n && expression[i].isDigit()) {
            val num = expression[i++].digitToInt()
            currNumerator = currNumerator * 10 + num
        }

        if (isNegative) {
            currNumerator *= -1
        }

        // skip '/' char
        if (expression[i] == '/') i++

        // build Denominator
        while (i < n && expression[i].isDigit()) {
            val num = expression[i++].digitToInt()
            currDenominator = currDenominator * 10 + num
        }

        // fraction calculation
        numerator = (numerator * currDenominator) + (currNumerator * denominator)
        denominator *= currDenominator

        // get GCD
        val gcd = abs(findGCD(numerator, denominator))

        // reduce the result fraction to irreducible
        numerator /= gcd
        denominator /= gcd
    }

    return "$numerator/$denominator"
}


private fun findGCD(a: Int, b: Int): Int {
    if (a == 0) return b
    return findGCD(b % a, a)
}
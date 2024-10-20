package j_october

/**
 *  Problem 20. Parsing A Boolean Expression
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
        "&(|(f))", "|(f,f,f,t)", "!(&(f,t))"
    )

    testCases.forEach { expression ->
        println("Result ==> ${parseBoolExpr(expression)}")
    }

}

fun parseBoolExpr(expression: String): Boolean {
    var mExpression = expression
    while (mExpression.length > 1) {
        val start = mExpression.lastIndexOf('!').coerceAtLeast(
            mExpression.lastIndexOf('&').coerceAtLeast(mExpression.lastIndexOf('|'))
        )
        val end = mExpression.indexOf(')', start)
        val subExpr = mExpression.substring(start, end + 1)
        val result = evaluateSubExpr(subExpr)
        mExpression = mExpression.substring(0, start) + result + mExpression.substring(end + 1)
    }
    return mExpression[0] == 't'
}


private fun evaluateSubExpr(subExpr: String): Char {
    val op = subExpr[0]
    val values = subExpr.substring(2, subExpr.length - 1)
    if (op == '!') return if (values[0] == 't') 'f' else 't'
    if (op == '&') return if (values.contains("f")) 'f' else 't'
    if (op == '|') return if (values.contains("t")) 't' else 'f'
    return 'f'
}
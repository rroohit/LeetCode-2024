package j_october


/**
 *  Problem 20. Parsing A Boolean Expression
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
        "&(|(f))", "|(f,f,f,t)", "!(&(f,t))"
    )

    testCases.forEach { expression ->
        println("Result ==> ${parseBoolExpr(expression)}")
    }

}

// Recursive
// TC - O(N) :: SC - O(N)
private var i = 0
fun parseBoolExpr(expression: String): Boolean {
    i = 0
    return evaluate(expression)
}

private fun evaluate(exp: String): Boolean {
    val char = exp[i++]
    if (char == 't') return true
    if (char == 'f') return false

    if (char == '!') {
        i++
        val result = !evaluate(exp)
        i++
        return result
    }

    val chars = mutableListOf<Boolean>()
    i++
    while(exp[i] != ')') {
        if (exp[i] != ',') {
            chars.add(evaluate(exp))
        } else i++
    }
    i++

    if (char == '&') return !chars.contains(false)
    if (char == '|') return chars.contains(true)
    return false
}

/////////////////////////////////////////
//
// String Manipulation
// TC - O(N^2) :: SC - O(N)
fun parseBoolExpr2(expression: String): Boolean {
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
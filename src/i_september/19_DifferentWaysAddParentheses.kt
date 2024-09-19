package i_september

/**
 *  Problem 19. Different Ways to Add Parentheses
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(3^N)
 *
 *       - Space complexity: O(3^N)
 *
 * ## Code -
 */
fun main() {

     val testCases = listOf(
         "2-1-1",
         "2*3-4*5"
     )

    testCases.forEach { expression ->
        println("Result ==> ${diffWaysToCompute(expression)}")
    }

}


fun diffWaysToCompute(expression: String): List<Int> = buildList {
    for ((i, c) in expression.withIndex()) if (!c.isDigit()) {
        val leftList = diffWaysToCompute(expression.take(i))
        val rightList = diffWaysToCompute(expression.drop(i + 1))
        for (left in leftList) for (right in rightList) add(when (c) {
            '+' -> left + right
            '-' -> left - right
            else -> left * right
        })
    }
    if (isEmpty()) add(expression.toInt())
}
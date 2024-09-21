package i_september


/**
 *  Problem 21. Lexicographical Numbers
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
        13,
        2
    )

    testCases.forEach { test ->
        println("Result ==> ${lexicalOrder(test)}")
    }

}

fun lexicalOrder(n: Int): List<Int> {
    val lexicographicalNumbers: MutableList<Int> = ArrayList()

    for (start in 1..9) {
        generateLexicalNumbers(start, n, lexicographicalNumbers)
    }
    return lexicographicalNumbers
}

private fun generateLexicalNumbers(
    currentNumber: Int,
    limit: Int,
    result: MutableList<Int>
) {
    if (currentNumber > limit) return

    result.add(currentNumber)

    for (nextDigit in 0..9) {
        val nextNumber = currentNumber * 10 + nextDigit
        if (nextNumber <= limit) {
            generateLexicalNumbers(nextNumber, limit, result)
        } else {
            break
        }
    }
}


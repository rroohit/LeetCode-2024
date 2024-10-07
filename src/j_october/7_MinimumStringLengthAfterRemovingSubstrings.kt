package j_october

import java.util.*

/**
 *  Problem 7. Minimum String Length After Removing Substrings.
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
        "ABFCACDB",
        "ACBBD"
    )

    testCases.forEach { s ->
        println("Result ==> ${minLength(s)}")
    }


}

fun minLength(s: String): Int {
    val stack = Stack<Char>()
    for (ch in s) {
        val top = stack.lastOrNull() ?: ' '
        when {
            ch == 'B' && top == 'A' -> stack.pop()
            ch == 'D' && top == 'C' -> stack.pop()
            else -> stack.push(ch)
        }
    }
    return stack.size
}
package g_july

import java.util.*

/**
 *  Problem 11. Reverse Substrings Between Each Pair of Parentheses
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n ^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "(abcd)",
        "(u(love)i)",
        "(ed(et(oc))el)"
    )

    testCases.forEach { s ->
        println("Result ==> ${reverseParentheses(s)}")
    }

}


fun reverseParentheses(s: String): String {
    val stack = Stack<Char>()
    for (ch in s) {
        if (ch == ')') {
            val sb = mutableListOf<Char>()
            while (stack.isNotEmpty()) {
                val lastCh = stack.removeLastOrNull()
                if (lastCh == null || lastCh == '(') break
                sb.add(lastCh)
            }
            stack.addAll(sb)
        } else {
            stack.push(ch)
        }
    }
    return stack.joinToString("")
}

fun reverseParentheses1(s: String): String {
    val stack = Stack<Char>()
    for (ch in s) {
        if (ch == ')') {
            val sb = StringBuilder()
            while (stack.isNotEmpty()) {
                val lastCh = stack.pop()
                if (lastCh == null || lastCh == '(') break
                sb.append(lastCh)
            }
            sb.forEach{ stack.push(it) }
        } else {
            stack.push(ch)
        }
    }
    return stack.joinToString("")
}

fun reverseParentheses3(s: String): String {
    val stack = mutableListOf<Char>()
    for (ch in s) {
        if (ch == ')') {
            val sb = mutableListOf<Char>()
            while (stack.isNotEmpty()) {
                val lastCh = stack.removeLastOrNull()
                if (lastCh == null || lastCh == '(') break
                sb.add(lastCh)
            }
            stack.addAll(sb)
        } else {
            stack.add(ch)
        }
    }
    return stack.joinToString("")
}
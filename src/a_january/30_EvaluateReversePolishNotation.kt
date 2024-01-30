package a_january

import java.util.*

/**
 *  Problem = 30 : Evaluate Reverse Polish Notation
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (1)
 *
 * # Code =>
 */
fun main() {

    // val tokens = arrayOf("2", "1", "+", "3", "*") ans - 9
    val tokens = arrayOf("4", "13", "5", "/", "+") // ans 6

    val result = evalRPN3(tokens)

    println("Result ==> $result")

}


fun evalRPN(tokens: Array<String>): Int {
    val stack = Stack<Int>()

    for (ch in tokens) {
        if (ch.isNum() == null) { // means its operator
            val y = stack.pop()!!
            val x = stack.pop()!!
            when (ch) {
                "+" -> stack.push(x + y)
                "-" -> stack.push(x - y)
                "*" -> stack.push(x * y)
                "/" -> stack.push(x / y)
            }
        } else {
            stack.push(ch.toInt())
        }
    }

    return stack.pop()
}

private fun String.isNum(): Int? = this.toIntOrNull()

//
fun evalRPN2(tokens: Array<String>): Int {
    val operators = listOf("+", "-", "*", "/")
    val stack = Stack<Int>()

    for (ch in tokens) {
        if (operators.contains(ch)) {
            val y = stack.pop()!!
            val x = stack.pop()!!
            when (ch) {
                "+" -> stack.push(x + y)
                "-" -> stack.push(x - y)
                "*" -> stack.push(x * y)
                "/" -> stack.push(x / y)
            }
        } else {
            stack.push(ch.toInt())
        }
    }

    return stack.pop()
}

//
fun evalRPN3(tokens: Array<String>): Int {
    val stack = Stack<Int>()

    for (ch in tokens) {
        when (ch) {
            "+" -> {
                val y = stack.pop()!!
                stack.push(stack.pop() + y)
            }
            "-" -> {
                val y = stack.pop()!!
                stack.push(stack.pop() - y)
            }
            "*" -> {
                val y = stack.pop()!!
                stack.push(stack.pop() * y)
            }
            "/" -> {
                val y = stack.pop()!!
                stack.push(stack.pop() / y)
            }
            else -> stack.push(ch.toInt())
        }

    }

    return stack.pop()
}

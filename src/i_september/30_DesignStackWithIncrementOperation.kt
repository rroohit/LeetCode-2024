package i_september

import kotlin.math.min

/**
 *  Problem 30. Design a Stack With Increment Operation
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple("push", 1, -1),
        Triple("push", 2, -1),
        Triple("pop", -1, -1),
        Triple("push", 2, -1),
        Triple("push", 3, -1),
        Triple("push", 4, -1),
        Triple("increment", 5, 100),
        Triple("increment", 2, 100),
        Triple("pop", -1, -1),
        Triple("pop", -1, -1),
        Triple("pop", -1, -1),
        Triple("pop", -1, -1),
    )

    val customStack = CustomStack(3)
    testCases.forEach { test ->
        val type = test.first
        when (type) {
            "push" -> {
                customStack.push(test.second)
                println("null")
            }

            "pop" -> {
                println(customStack.pop())
            }

            "increment" -> {
                customStack.increment(test.second, test.third)
                println("null")
            }
        }
    }

}

class CustomStack(maxSize: Int) {
    private val stack = IntArray(maxSize)
    private var insertInd = 0
    private var popInd = 0
    fun push(x: Int) {
        if (insertInd == stack.size) return
        if (insertInd < 0) insertInd = 0
        stack[insertInd] = x
        popInd = insertInd
        insertInd++
    }

    fun pop(): Int {
        return if (popInd >= 0) {
            insertInd--
            stack[popInd--]
        } else {
            -1
        }
    }

    fun increment(k: Int, `val`: Int) {
        val min = min(stack.size, k)
        repeat(min) { i ->
            stack[i] += `val`
        }
    }
}
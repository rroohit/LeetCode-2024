package a_january

import java.util.*

/**
 *  Problem = 29 : Implement Queue using Stacks
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (n)
 *
 * # Code =>
 */
fun main() {



}

class MyQueue() {
    // Sol. 1.
    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()
    fun push(x: Int) {
        stack1.push(x)
    }

    fun pop(): Int {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }

    fun peek(): Int {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.peek()
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }


    // Sol. 2.
    /*private val list1 = mutableListOf<Int>()
    private val list2 = mutableListOf<Int>()

    fun push(x: Int) {
        list1.add(x)
    }

    fun pop(): Int {
        if (list2.isEmpty()) {
            while (list1.isNotEmpty()) {
                list2.add(list1.removeLast())
            }
        }
        return list2.removeLast()
    }

    fun peek(): Int {
        if (list2.isEmpty()) {
            while (list1.isNotEmpty()) {
                list2.add(list1.removeLast())
            }
        }
        return list2.last()
    }

    fun empty(): Boolean {
        return list2.isEmpty() && list1.isEmpty()
    }*/


}
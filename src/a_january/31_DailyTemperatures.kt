package a_january

import java.util.*

/**
 *  Problem = 31 : Daily Temperatures
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    // ans - [8,1,5,4,3,2,1,1,0,0]
    val temperatures = intArrayOf(89, 62, 70, 58, 47, 47, 46, 76, 100, 70)

    val result = dailyTemperatures(temperatures)

    println("Result ==> ${result.toList()}")

}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val ans = IntArray(temperatures.size)
    val st = Stack<Int>() // stack for monotonic seq will keep index in here

    for (i in temperatures.size - 1 downTo 0) {
        val temp = temperatures[i]
        // check for top element with curr temp.
        while (st.isNotEmpty() && temperatures[st.peek()] <= temp) st.pop()

        // if still stack is not empty means we have an ans for i-th position.
        if (st.isNotEmpty()) ans[i] = st.peek() - i

        // no doubt there is temp at top of stack that will less than curr temp so will push.
        st.push(i)
    }

    return ans
}
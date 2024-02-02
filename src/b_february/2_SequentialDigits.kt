package b_february

import java.util.*

/**
 *  Problem = 2 : Sequential Digits
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

    val low = 10
    val high = 1000000000

    val result = sequentialDigits(low, high)

    println("Result ==> $result")

}

fun sequentialDigits(low: Int, high: Int): List<Int> {
    val ans = mutableListOf<Int>()

    val queue: LinkedList<Int> = LinkedList()
    for (i in 1..9) {
        queue.offer(i)
    }

    while (queue.isNotEmpty()) {
        val n = queue.pollFirst()
        if (n > high) continue

        if (n in low..high) {
            ans.add(n)
        }

        val one = n % 10
        if (one < 9) {
            val newNum = (one + 1 +( n * 10))
            queue.offer(newNum)
        }

    }


    return ans
}


package j_october

import java.util.*

/**
 *  Problem 14. Maximal Score After Applying K Operations
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N *Log(N) + K * Log(N))
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(10, 10, 10, 10, 10), 5),
        Pair(intArrayOf(1, 10, 3, 3, 3), 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${maxKelements(test.first, test.second)}")
    }

}

fun maxKelements(nums: IntArray, k: Int): Long {
    val pq = PriorityQueue<Int> { t1, t2 -> t2 - t1 }
    for (num in nums) {
        pq.offer(num)
    }

    var ans = 0L
    repeat(k) {
        val pop = pq.poll()
        ans += pop
        pq.add(genNewData(pop))
    }
    return ans
}

fun genNewData(input: Int): Int {
    return if (input % 3 == 0) {
        input / 3
    } else {
        (input / 3) + 1
    }
}
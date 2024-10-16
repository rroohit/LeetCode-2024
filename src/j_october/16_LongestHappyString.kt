package j_october

import java.util.*

/**
 *  Problem 16. Longest Happy String
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(a + b + c)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(1, 1, 7)
    )

    testCases.forEach { test ->
        println("Result ==> ${longestDiverseString(test.first, test.second, test.third)}")
    }

}

fun longestDiverseString(a: Int, b: Int, c: Int): String {
    val pq = PriorityQueue<IntArray> { t1, t2 -> t2[0] - t1[0] } // count -> charType
    if (a > 0) pq.offer(intArrayOf(a, 1))
    if (b > 0) pq.offer(intArrayOf(b, 2))
    if (c > 0) pq.offer(intArrayOf(c, 3))

    val ans = StringBuilder()
    while (pq.isNotEmpty()) {
        val top = pq.poll() ?: break
        var topCount = top[0]

        // check curr char will it form the three consecutive char
        if (ans.length >= 2 &&
            ans[ans.length - 1] == getChar(top[1]) &&
            ans[ans.length - 2] == getChar(top[1])
        ) {
            if (pq.isEmpty()) break // no more char left to add
            val secondTop = pq.poll() ?: break
            ans.append(getChar(secondTop[1]))
            if (secondTop[0] - 1 > 0) pq.offer(intArrayOf(secondTop[0] - 1, secondTop[1]))

        } else {
            topCount--
            ans.append(getChar(top[1]))
        }
        if (topCount > 0) pq.offer(intArrayOf(topCount, top[1]))
    }

    return ans.toString()
}


private fun getChar(type: Int) = when (type) {
    1 -> 'a'
    2 -> 'b'
    3 -> 'c'
    else -> ""
}

private data class CharPair(
    var charCount: Int = 0,
    var char: Char
)
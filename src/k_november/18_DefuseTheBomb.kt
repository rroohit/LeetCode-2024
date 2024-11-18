package k_november

import kotlin.math.abs

/**
 *  Problem 18. Defuse the Bomb.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * k)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(5, 7, 1, 4), 3),
        Pair(intArrayOf(1, 2, 3, 4), 0),
        Pair(intArrayOf(2, 4, 9, 3), -2)
    )

    testCases.forEach { test ->
        println("Result ==> ${decrypt(test.first, test.second).toList()}")
    }

}

fun decrypt(code: IntArray, k: Int): IntArray {
    val decrypted = IntArray(code.size) { 0 }
    if (k == 0) return decrypted

    for (i in code.indices) {
        if (k > 0) {
            for (j in i + 1..<i + k + 1) {
                decrypted[i] += code[j % code.size]
            }
        } else {
            for (j in i - abs(k)..<i) {
                decrypted[i] += code[(j + code.size) % code.size]
            }
        }
    }

    return decrypted
}
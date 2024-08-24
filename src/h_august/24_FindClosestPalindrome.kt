package h_august

import kotlin.math.absoluteValue
import kotlin.math.pow

/**
 *  Problem 24. Find the Closest Palindrome
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

     val testCases = listOf(
         "123",
         "121",
         "1"
     )

    testCases.forEach { n ->
        println("Result ==> ${nearestPalindromic(n)}")
    }


}

fun nearestPalindromic(n: String): String {
    val number = n.toLong()
    val length = n.length
    if (length == 1) return (number - 1).toString()

    val center = if (length % 2 == 0) length / 2 - 1 else length / 2
    val firstHalf = n.substring(0, center + 1)

    return listOf(
        getPalindrome(firstHalf) { length % 2 == 0 },
        getPalindrome(firstHalf.toLong().inc().toString()) { length % 2 == 0 },
        getPalindrome(firstHalf.toLong().dec().toString()) { length % 2 == 0 },
        10.0.pow(length - 1).toLong().dec().toString(),
        10.0.pow(length).toLong().inc().toString()
    ).map { it.toLong() }
        .filter { it != number }
        .minWith(compareBy<Long> { it.minus(number).absoluteValue }.thenBy { it })
        .toString()
}

private fun getPalindrome(firstHalf: String, even: () -> Boolean) = when {
    even() -> firstHalf + firstHalf.reversed()
    else -> firstHalf + firstHalf.dropLast(1).reversed()
}
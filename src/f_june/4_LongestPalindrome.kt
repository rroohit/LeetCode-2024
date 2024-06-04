package f_june

/**
 *  Problem 4. Longest Palindrome
 *
 *  ## Intuition -
 *
 *  ## Approach - Hashtable frequency count
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "kkkK",
        "abccccdd",
        "a",
        "abc"
    )

    testCases.forEach { s ->
        println("Result ==> ${longestPalindrome(s)}")
    }

}

fun longestPalindrome(s: String): Int {
    val freq = IntArray(128) { 0 }
    var noOfOnes = 0
    var palindromeLen = 0

    for (c in s) {
        freq[c.code]++
        if (freq[c.code] % 2 == 0) noOfOnes-- else noOfOnes++
        if (freq[c.code] % 2 == 0) palindromeLen += 2
    }

    if (noOfOnes > 0) palindromeLen++
    return palindromeLen
}
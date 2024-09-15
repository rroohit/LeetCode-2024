package i_september

import kotlin.math.max


/**
 *  Problem 15.  Find the Longest Substring Containing Vowels in Even Counts
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "eleetminicoworoep",
        "leetcodeisgreat",
        "bcbcbc"
    )

    testCases.forEach { test ->
        println("Result ==> ${findTheLongestSubstring(test)}")
    }

}

fun findTheLongestSubstring(s: String): Int {
    var prefixXOR = 0
    val characterMap = IntArray(26)
    characterMap['a'.code - 'a'.code] = 1
    characterMap['e'.code - 'a'.code] = 2
    characterMap['i'.code - 'a'.code] = 4
    characterMap['o'.code - 'a'.code] = 8
    characterMap['u'.code - 'a'.code] = 16
    val mp = IntArray(32)
    for (i in 0..31) mp[i] = -1
    var longestSubstring = 0
    for (i in s.indices) {
        prefixXOR = prefixXOR xor characterMap[s[i].code - 'a'.code]
        if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i
        longestSubstring = max(longestSubstring.toDouble(), (i - mp[prefixXOR]).toDouble()).toInt()
    }
    return longestSubstring
}
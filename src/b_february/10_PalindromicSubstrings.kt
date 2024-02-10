package b_february

/**
 *  Problem = 10 : Palindromic Substrings
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n^2)
 *
 *      - Space complexity: O(1)
 *
 * # Code =>
 */
fun main() {

    val s = "aabc"

    val result = countSubstrings(s)

    println("Result ==> $result")

}

fun countSubstrings(s: String): Int {
    var count = 0

    for (i in s.indices) {
        count += countPalind(s, i, i) // for odd
        count += countPalind(s, i, i + 1) // for even
    }

    return count
}

private fun countPalind(s: String, l: Int, r: Int): Int {
    var count = 0
    var L = l
    var R = r

    while (L >= 0 && R < s.length && s[L] == s[R]){
        count++
        L--
        R++
    }
    return count
}
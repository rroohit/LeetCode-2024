package b_february

/**
 *  Problem = 13. Find First Palindromic String in the Array
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *          - n is size of given words array
 *          - m is total words length of all given words.
 *              (i.e m / 2 - because we are traveling half of string to check the string is palindrome)
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val words = arrayOf("abc", "car", "ada", "racecar", "cool")

    val result = firstPalindrome(words)

    println("Result ==> $result")
}

fun firstPalindrome(words: Array<String>): String {
    for (word in words){
        if (word.isPalindromic()) return word
    }
    return ""
}

private fun String.isPalindromic(): Boolean {
    var l = 0
    var r = length - 1
    while (l < r) {
        if (this[l] != this[r]) return false
        l++
        r--
    }
    return true
}
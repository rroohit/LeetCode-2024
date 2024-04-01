package d_april

/**
 *  Problem 1. Length of Last Word
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val s = "luffy is still joyboy"

    println("Result ==> ${lengthOfLastWord(s)}")

}

// TC - O(n) : SC - O(1)
fun lengthOfLastWord(s: String): Int {
    var len = 0
    var i = s.length - 1
    while (s[i] == ' ' && i > 0) i--


    while (i >= 0 && s[i] != ' ') {
        i--
        len++
    }

    return len
}
package k_november

/**
 *  Problem 1. Delete Characters to Make Fancy String
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "leeetcode",
        "aaabaaaa",
        "aab"
    )

    testCases.forEach { str ->
        println("Result ==> ${makeFancyString(str)}")
    }

}

fun makeFancyString(s: String): String {
    val sb = StringBuilder()
    var lastCh = ' '
    var currCount = 1
    for (ch in s) {
        if (lastCh == ch) {
            if (++currCount <= 2) sb.append(ch)
        } else {
            currCount = 1
            sb.append(ch)
        }
        lastCh = ch
    }
    return sb.toString()
}
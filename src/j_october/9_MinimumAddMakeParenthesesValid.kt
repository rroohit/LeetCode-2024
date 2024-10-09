package j_october

/**
 *  Problem 9. Minimum Add to Make Parentheses Valid.
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
        "())",
        "((("
    )

    testCases.forEach { str ->
        println("Result ==> ${minAddToMakeValid(str)}")
    }

}

fun minAddToMakeValid(s: String): Int {
    var opening = 0
    var unbalanced = 0
    for (ch in s) {
        if (ch == '(') {
            opening++
        } else {
            if (opening > 0) opening-- else unbalanced++
        }
    }
    return (opening + unbalanced)
}
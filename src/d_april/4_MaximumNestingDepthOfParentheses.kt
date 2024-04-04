package d_april

import kotlin.math.max

/**
 *  Problem 4. Maximum Nesting Depth of the Parentheses
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

    val s = "(1+(2*3)+((8)/4))+1"

    println("Result ==> ${maxDepth(s)}")

}

fun maxDepth(s: String): Int {
    val opened = '('
    val closed = ')'
    var res = 0
    var seen = 0

    for (c in s) {
        if (c == opened) {
            seen++
        } else if (c == closed) {
            res = max(res, seen)
            seen--
        }
    }

    return res
}
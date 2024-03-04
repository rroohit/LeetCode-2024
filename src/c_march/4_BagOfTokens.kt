package c_march

import kotlin.math.max

/**
 *  Problem 4. Bag of Tokens
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val tokens = intArrayOf(100, 200, 300, 400)
    val power = 200

    val result = bagOfTokensScore(tokens, power)

    println("Result ==> $result")

}

// Two pointers algorithm
fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    tokens.sort()
    var res = 0 // to track max score
    var sco = 0 // curr score
    var pow = power
    var l = 0
    var r = tokens.size - 1

    while (l <= r) {
        if (pow >= tokens[l]) {
            pow -= tokens[l++]
            sco++
            res = max(res, sco)
        } else if (sco > 0) {
            pow += tokens[r--]
            sco--
        } else break
    }

    return res
}
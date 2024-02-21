package b_february

/**
 *  Problem 21.  Bitwise AND of Numbers Range
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(log(max(left, right)))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val left = 5
    val right = 7

    println("Result ==> ${rangeBitwiseAnd(left, right)}")

}

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var l = left
    var r = right
    var i = 0
    while (l != r) {
        l = l shr 1
        r = r shr 1
        i++
    }
    return l shl i
}
package d_april

/**
 *  Problem 11. Remove K Digits
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val num = "9"
    val k = 1

    println("Result ==> ${removeKdigits(num, k)}")

}

fun removeKdigits(num: String, k: Int): String {
    val stack = StringBuilder()
    var kk = k
    for (ch in num) {
        while (kk > 0 && stack.isNotEmpty() && stack.last() > ch) {
            kk--
            stack.deleteAt(stack.length - 1)
        }
        stack.append(ch)
    }

    // remove last elements if still k elements left to remove
    while (kk > 0) {
        stack.deleteAt(stack.length - 1)
        kk--
    }

    // Remove leading zero's
    while (stack.isNotEmpty() && stack.first() == '0'){
        stack.deleteAt(0)
    }

    if (stack.isEmpty()) return "0"
    return stack.toString()
}













package d_april

/**
 *  Problem 6. Minimum Remove to Make Valid Parentheses
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

    val list = listOf("lee(t(c)o)de)", "a)b(c)d", "))((", "())()(((")

    list.forEach { s ->
        println("$s : Result ==> ${minRemoveToMakeValid(s)}")
    }
}

fun minRemoveToMakeValid(s: String): String {
    val ans = StringBuilder()
    val openPar = '('  // open parentheses
    val closePar = ')' // close parentheses
    var count = 0 //

    for (ch in s) {
        if (ch == openPar) {
            ans.append(ch)
            count++
        } else if (ch == closePar && count > 0) {
            ans.append(ch)
            count--
        } else if (ch != closePar) {
            ans.append(ch)
        }
    }

    for (i in ans.length - 2 downTo -1) {
        val ch = ans[i + 1]
        if (ch == openPar && count > 0) {
            ans.deleteAt(i + 1)
            count--
        }
        if (count == 0) break
    }

    return ans.toString()
}












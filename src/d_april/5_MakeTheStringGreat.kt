package d_april

/**
 *  Problem 5. Make The String Great
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

    val list = listOf("leEeetcodeKkK", "abBAcC", "Pp", "kkdsFuqUfSDKK")

    list.forEach { s ->
        println("Result ==> ${makeGood(s)}")
    }

}

fun makeGood(s: String): String {
    val stack = StringBuilder()
    stack.append(s[0])

    for (i in 1..<s.length) {
        val curr = s[i]
        if (stack.isEmpty()) {
            stack.append(curr)
            continue
        }

        val last = stack[stack.length - 1]

        // if both or equal and any one of is Uppercase need to remove
        if (curr.lowercase() == last.lowercase() && curr != last) {
            if (stack.isNotEmpty()) {
                stack.deleteAt(stack.length - 1)
            }
        } else {
            stack.append(curr)
        }

    }

    return stack.toString()
}
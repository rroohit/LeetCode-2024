package d_april

/**
 *  Problem 7. Valid Parentheses String
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

    val s = ")(*(*))))"

    println("Result ==> ${checkValidString(s)}")

}

fun checkValidString(s: String): Boolean {
    var leftMin = 0
    var leftMax = 0

    for (c in s) {
        when (c) {
            '(' -> {
                leftMin++
                leftMax++
            }
            ')' -> {
                leftMin--
                leftMax--
            }
            else -> {
                leftMin--
                leftMax++
            }
        }
        if (leftMax < 0) {
            return false
        }
        if (leftMin < 0) {
            leftMin = 0
        }
    }
    return leftMin == 0
}

fun checkValidString1(s: String): Boolean {
    val dp = mutableMapOf<Pair<Int, Int>, Boolean>() // key=(i, leftCount) -> isValid

    fun dfs(i: Int, left: Int): Boolean {
        if (i == s.length || left < 0) {
            return left == 0
        }
        if (Pair(i, left) in dp) {
            return dp[Pair(i, left)]!!
        }

        val result = when {
            s[i] == '(' -> dfs(i + 1, left + 1)
            s[i] == ')' -> dfs(i + 1, left - 1)
            else -> dfs(i + 1, left + 1) || dfs(i + 1, left - 1) || dfs(i + 1, left)
        }
        dp[Pair(i, left)] = result
        return result
    }

    return dfs(0, 0)
}
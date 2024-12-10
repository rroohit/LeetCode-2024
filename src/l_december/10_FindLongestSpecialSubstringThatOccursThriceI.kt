package l_december


/**
 *  Problem 10. Find Longest Special Substring That Occurs Thrice I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "aaaa",
        "abcdef",
        "abcaba"
    )

    testCases.forEach { s ->
        println("Result ==> ${maximumLength(s)}")
    }

}

fun maximumLength(s: String): Int {
    val count: MutableMap<Pair<Char, Int>, Int> = HashMap()
    var substringLength: Int

    for (start in s.indices) {
        val character = s[start]
        substringLength = 0

        for (end in start..<s.length) {
            if (character == s[end]) {
                substringLength++
                val key = Pair(
                    character,
                    substringLength
                )
                count[key] = count.getOrDefault(key, 0) + 1
            } else {
                break
            }
        }
    }

    var ans = 0
    for (entry in count) {
        val length: Int = entry.key.second
        if (entry.value >= 3 && length > ans) {
            ans = length
        }
    }

    return if (ans == 0) -1 else ans
}


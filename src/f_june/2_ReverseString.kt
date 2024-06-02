package f_june

/**
 *  Problem 2. Reverse String
 *
 *  ## Intuition -
 *
 *  ## Approach - Two pointers
 *
 *  ## Complexity:
 *       - Time complexity: O(n / 2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        charArrayOf('h', 'e', 'l', 'l', 'o'),
        charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    )

    testCases.forEach { s ->
        println("Before reversing => ${s.toList()}")
        reverseString(s)
        println("After reversing  => ${s.toList()}")
        println()
    }

}

fun reverseString(s: CharArray): Unit {
    var l = 0            // left pointer
    var r = s.size - 1  // right pointer

    while (l < r) {
        val temp = s[l]
        s[l++] = s[r]
        s[r--] = temp
    }
}
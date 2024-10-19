package j_october

/**
 *  Problem 19. Find Kth Bit in Nth Binary String
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(2^N)
 *
 *       - Space complexity: O(2^N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(3, 1),
        Pair(4, 11)
    )

    testCases.forEach { test ->
        println("Result ==> ${findKthBit(test.first, test.second)}")
        println()
    }

}

// Brute force
fun findKthBit(n: Int, k: Int): Char {
    val strBld = StringBuilder()
    strBld.append("0")

    repeat(n - 1) {
        buildNewString(strBld)
        println("${it + 2} -> $strBld")
        if (strBld.length >= k) return@repeat
    }

    return strBld.toString()[k - 1]
}

private fun buildNewString(strBld: StringBuilder) {
    val invertedString = StringBuilder()
    strBld.toString().forEach { invertedString.append(if (it == '0') "1" else "0") }
    strBld.append("1")
    invertedString.reverse().forEach { strBld.append(it) }
}














package l_december

/**
 *  Problem 4. Make String a Subsequence Using Cyclic Increments.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("abc", "ad"),
        Pair("zc", "ad"),
        Pair("ab", "d")
    )

    testCases.forEach { test ->
        println("Result ==> ${canMakeSubsequence(test.first, test.second)}")
    }

}

fun canMakeSubsequence(str1: String, str2: String): Boolean {
    var str2Index = 0
    val lengthStr1: Int = str1.length
    val lengthStr2 = str2.length

    var str1Index = 0
    while (str1Index < lengthStr1 && str2Index < lengthStr2) {

        if (str1[str1Index] == str2[str2Index] ||
            (str1[str1Index] + 1 == str2[str2Index]) ||
            (str1[str1Index] - 25 == str2[str2Index])
        ) {
            str2Index++
        }
        str1Index++
    }

    return str2Index == lengthStr2
}
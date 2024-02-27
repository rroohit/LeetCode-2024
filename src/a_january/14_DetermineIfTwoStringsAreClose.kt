package a_january

/**
 *  Problem 14. Determine if Two Strings Are Close
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(26) = O(1)
 *
 * ## Code -
 */
fun main() {

    val word1 = "cabbba"
    val word2 = "abbccc"

    println("Result ==> ${closeStrings(word1, word2)}")

}

fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false
    val alphaCountOne = IntArray(26) { 0 }
    val alphaCountTwo = IntArray(26) { 0 }

    val setOne = BooleanArray(26) { false }
    val setTwo = BooleanArray(26) { false }

    word1.zip(word2).forEach { pair ->
        val a = pair.first
        val b = pair.second
        alphaCountOne[a - 'a']++
        alphaCountTwo[b - 'a']++

        setOne[a - 'a'] = true
        setTwo[b - 'a'] = true
    }


    return (alphaCountOne.toList().sorted() == alphaCountTwo.toList().sorted() && setOne.contentEquals(setTwo))
}
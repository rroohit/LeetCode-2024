package k_november

/**
 *  Problem 2. Circular Sentence.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "leetcode exercises sound delightful",
        "eetcode",
        "Leetcode is cool"
    )

    testCases.forEach { sentence ->
        println("Result ==> ${isCircularSentence(sentence)}")
    }

}

fun isCircularSentence(sentence: String): Boolean {
    if (sentence.first() != sentence.last()) return false
    for (i in sentence.indices) {
        if (sentence[i] == ' ') {
            if (sentence[i - 1] != sentence[i + 1]) return false
        }
    }
    return true
}

fun isCircularSentence1(sentence: String): Boolean {
    if (sentence.first() != sentence.last()) return false
    val listWords = sentence.split(" ")
    for (i in 1..listWords.size - 2) {
        val currWord = listWords[i]
        val nextWord = listWords[i + 1]
        if (currWord.last() != nextWord.first()) return false
    }
    return true
}
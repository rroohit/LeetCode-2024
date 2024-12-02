package l_december

import kotlin.math.min

/**
 *  Problem 2. Check If a Word Occurs As a Prefix of Any Word in a Sentence.
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

    val testCases = listOf(
        Pair("i love eating burger", "burg"),
        Pair("a a b c d z", "z")
    )

    testCases.forEach { test ->
        println("Result ==> ${isPrefixOfWord(test.first, test.second)}")
    }

}

fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    var wordInd = 1
    var l = 0

    while (l < sentence.length) {
        var prefInd = 0
        while (prefInd < searchWord.length && l < sentence.length && searchWord[prefInd] == sentence[l]) {
            prefInd++
            l++
        }

        if (prefInd == searchWord.length) return wordInd
        while (l < sentence.length && sentence[l] != ' ') l++

        l++
        wordInd++
    }

    return -1
}

// TC - O(n * m) :: SC - O(n)
fun isPrefixOfWord1(sentence: String, searchWord: String): Int {
    val listOfWords = sentence.split(" ") // TC & SC - O(n)
    for (i in listOfWords.indices) { // TC - O(n)
        val word = listOfWords[i]
        if (isPrefixMatch(word, searchWord)) return i + 1
    }
    return -1
}

private fun isPrefixMatch(word: String, pref: String): Boolean {
    var l = 0
    while (l < min(word.length, pref.length)) { // O(m)
        if (word[l] != pref[l]) break
        l++
    }
    return l == (pref.length)
}
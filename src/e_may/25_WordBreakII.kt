package e_may

/**
 *  Problem 25. Word Break II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("catsanddog", listOf("cat", "cats", "and", "sand", "dog"))
    )

    testCases.forEach { test ->
        println("Result ==> ${wordBreak(test.first, test.second)}")
    }

}

private val listOfWords = mutableListOf<String>()
fun wordBreak(s: String, wordDict: List<String>): List<String> {
    listOfWords.clear()
    buildWords(0, s, wordDict.toSet(), mutableListOf())
    return listOfWords
}

private fun buildWords(curInd: Int, s: String, wordDict: Set<String>, curList: MutableList<String>) {
    // Base case
    if (curInd == s.length) {
        listOfWords.add(curList.joinToString(" "))
        return
    }

    for (i in curInd..<s.length) {
        val subStr = s.substring(curInd, i + 1)
        if (wordDict.contains(subStr)) {
            curList.add(subStr)
            buildWords(i +1, s, wordDict, curList)
            curList.removeLastOrNull() // backtracking
        }
    }

}
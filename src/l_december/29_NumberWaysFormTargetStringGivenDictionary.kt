package l_december


/**
 *  Problem 29. Number of Ways to Form a Target String Given a Dictionary.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(wordLength⋅targetLength + wordLength⋅totalWords)
 *
 *       - Space complexity:  O(wordLength⋅targetLength)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("acca", "bbbb", "caca"), "aba"
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${numWays(test.first, test.second)}")
    }

}

fun numWays(words: Array<String>, target: String): Int {
    val wordLength = words[0].length
    val targetLength = target.length

    val dp = Array(wordLength) { IntArray(targetLength) { -1 } }
    val charFrequency = Array(wordLength) { IntArray(26) }

    for (word in words) {
        for (j in 0..<wordLength) {
            val character = word[j] - 'a'
            charFrequency[j][character]++
        }
    }

    return getWords(words, target, 0, 0, dp, charFrequency).toInt()
}

private fun getWords(
    words: Array<String>,
    target: String,
    wordsIndex: Int,
    targetIndex: Int,
    dp: Array<IntArray>,
    charFrequency: Array<IntArray>
): Long {
    val MOD = 1000000007

    if (targetIndex == target.length) return 1

    if (wordsIndex == words[0].length ||
        words[0].length - wordsIndex < target.length - targetIndex
    ) return 0

    if (dp[wordsIndex][targetIndex] != -1
    ) return dp[wordsIndex][targetIndex].toLong()

    var countWays: Long = 0
    val curPos = target[targetIndex].code - 'a'.code

    countWays += getWords(
        words,
        target,
        wordsIndex + 1,
        targetIndex,
        dp,
        charFrequency
    )

    countWays +=
        charFrequency[wordsIndex][curPos] *
                getWords(
                    words,
                    target,
                    wordsIndex + 1,
                    targetIndex + 1,
                    dp,
                    charFrequency
                )

    dp[wordsIndex][targetIndex] = (countWays % MOD).toInt()

    return dp[wordsIndex][targetIndex].toLong()
}
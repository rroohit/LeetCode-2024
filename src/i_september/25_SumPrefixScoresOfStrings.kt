package i_september

/**
 *  Problem 25. Sum of Prefix Scores of Strings
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * K)
 *
 *       - Space complexity: O(N * K)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("abc", "ab", "bc", "b")
    )

    testCases.forEach { test ->
        println("Result ==> ${sumPrefixScores(test).toList()}")
    }

}

private val trieNode = PrefixTrie()
fun sumPrefixScores(words: Array<String>): IntArray {
    var scoreResult = IntArray(words.size)
    for (word in words) {
        insertWordInTrie(word)
    }

    for (i in words.indices) {
        scoreResult[i] = getWordScore(words[i])
    }

    return scoreResult
}

private fun insertWordInTrie(word: String) {
    var root = trieNode
    for (ch in word) {
        val index = ch - 'a'
        if (root.next[index] == null) root.next[index] = PrefixTrie()
        root = root.next[index]!!
        root.cnt++
    }
}

private fun getWordScore(word: String): Int {
    var root = trieNode
    var score = 0
    for (ch in word) {
        val index = ch - 'a'
        score += root.next[index]?.cnt ?: 0
        root = root.next[index]!!
    }
    return score
}

private data class PrefixTrie(
    val next: Array<PrefixTrie?> = arrayOfNulls(26),
    var cnt: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PrefixTrie

        if (!next.contentEquals(other.next)) return false
        if (cnt != other.cnt) return false

        return true
    }

    override fun hashCode(): Int {
        var result = next.contentHashCode()
        result = 31 * result + cnt
        return result
    }
}
package i_september

/**
 *  Problem 17. Uncommon Words from Two Sentences
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(s1.length + s2.length)
 *
 *       - Space complexity: O(s1.length + s2.length)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("this apple is sweet", "this apple is sour"),
        Pair("apple apple", "banana")
    )

    testCases.forEach { test ->
        println("Result ==> ${uncommonFromSentences(test.first, test.second).toList()}")
    }

}

fun uncommonFromSentences(s1: String, s2: String): Array<String> {
    val wordCount = HashMap<String, Int>() // string -> count
    buildWordCount("$s1 $s2", wordCount)
    val uniqueCount = wordCount.count { it.value == 1 }
    val result = Array<String>(uniqueCount) { "" }
    var i = 0
    for ((word, count) in wordCount) {
        if (count == 1) result[i++] = word
    }
    return result
}

private fun buildWordCount(string: String, map: HashMap<String, Int>) {
    val n = string.length
    var i = 0
    while (i < n) {
        val sb = StringBuilder()
        while (i < n && string[i] != ' ') {
            sb.append(string[i++])
        }
        map[sb.toString()] = map.getOrDefault(sb.toString(), 0) + 1
        i++
    }
}
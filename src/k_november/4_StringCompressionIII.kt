package k_november

/**
 *  Problem 4. String Compression III
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "abcde",
        "aaaaaaaaaaaaaabb",
        "rrkkssoolllllllllllllllllllllllllllllllllllll"
    )

    testCases.forEach { word ->
        println("Result ==> ${compressedString(word)}")
    }

}

fun compressedString(word: String): String {
    val sb = StringBuilder()
    var i = 0
    while (i < word.length) {
        val curr = word[i]
        var count = 1
        while (i < word.length - 1 && count < 9 && curr == word[i + 1]) {
            i++
            count++
        }
        sb.append("$count$curr")
        i++
    }
    return sb.toString()
}
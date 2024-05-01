package e_may

/**
 *  Problem 1. Reverse Prefix of Word
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(3n) = O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair('d', "abcdefd"),
        Pair('z', "xyxzxe"),
        Pair('z', "abcd")
    )

    testCases.forEach { test ->
        val word = test.second
        val ch = test.first
        println("Result :: $word ==> ${reversePrefix(word, ch)}")
    }

}

fun reversePrefix(word: String, ch: Char): String {
    var r = -1 // index of ch occurrence
    for (i in word.indices) { // O(n) - TC
        if (word[i] == ch) {
            r = i
            break
        }
    }
    // if ch is not in word
    if (r == -1) return word

    val newStr = word.toCharArray() // O(n) - SC
    for (l in 0.. r / 2) {
        val temp = newStr[l]
        newStr[l] = newStr[r - l]
        newStr[r - l] = temp
    }

    return String(newStr)
}

fun reversePrefix2(word: String, ch: Char): String {
    var indCh = -1 // index of ch occurrence
    for (i in word.indices) { // O(n) - TC
        if (word[i] == ch) {
            indCh = i
            break
        }
    }

    // if ch is not in word
    if (indCh == -1) return word

    val stringBuilder = StringBuilder() // O(n) - SC

    for (i in indCh downTo 0) { // O(n) - TC
        stringBuilder.append(word[i])
    }

    for (i in indCh + 1..<word.length) { // O(n) - TC
        stringBuilder.append(word[i])
    }

    return stringBuilder.toString()
}
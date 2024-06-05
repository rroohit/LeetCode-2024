package f_june

import kotlin.math.abs
import kotlin.math.min

/**
 *  Problem 5. Find Common Characters
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *          - n is size of array
 *          - m is the longest length of string
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("bella", "label", "roller"), arrayOf("cool", "lock", "cook")
    )

    testCases.forEach { words ->
        println("Result ==> ${commonChars(words)}")
        println()
    }

}

fun commonChars(words: Array<String>): List<String> {
    val freqCount = words[0].getCharCount()

    for (word in words) {
        val secFreqCount = word.getCharCount()
        for (char in words[0]) {
            freqCount[char] = min(freqCount.getOrDefault(char, 0), secFreqCount.getOrDefault(char, 0))
        }
    }

    val commonChars = mutableListOf<String>()
    for ((char, u) in freqCount) {
        repeat(u) {
            commonChars.add("$char")
        }
    }

    return commonChars
}

private fun String.getCharCount(): HashMap<Char, Int> {
    val freqCount = HashMap<Char, Int>()
    for (char in this) {
        freqCount[char] = freqCount.getOrDefault(char, 0) + 1
    }
    return freqCount
}

fun commonChars2(words: Array<String>): List<String> {
    val charCount = Array(words.size){ IntArray(26){0} }
    for (i in words.indices) {
        words[i].forEach{ ch ->
            charCount[i][abs('a' - ch)]++
        }
    }

    val commonChar = mutableListOf<String>()
    for (char in 'a'..'z') {
        val charInd = abs('a' - char)
        var curCnt = charCount[0][charInd]
        if (curCnt == 0) continue

        for (wrdCnt in charCount) {
            curCnt = min(curCnt, wrdCnt[charInd])
            if (curCnt == 0) break
        }

        repeat(curCnt){
            commonChar.add("$char")
        }
    }

    return commonChar
}
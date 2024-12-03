package l_december

/**
 *  Problem 3. Adding Spaces to a String.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            "LeetcodeHelpsMeLearn", intArrayOf(8, 13, 15)
        ),
        Pair(
            "icodeinpython", intArrayOf(1, 5, 7, 9)
        ),
        Pair(
            "spacing", intArrayOf(0, 1, 2, 3, 4, 5, 6)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${addSpaces(test.first, test.second)}")
        println()
    }

}

fun addSpaces(s: String, spaces: IntArray): String {
    val result = StringBuilder()

    var spaceInd = 0
    for (i in s.indices) {
        if (spaceInd < spaces.size && i == spaces[spaceInd]) {
            result.append(' ')
            spaceInd++
        }
        result.append(s[i])
    }

    return result.toString()
}

fun addSpaces1(s: String, spaces: IntArray): String {
    val result = StringBuilder() // SC - O(n)

    var start = 0

    for (end in spaces) { // O(m)
        val sub = s.substring(start, end)
        if (sub.isEmpty()) { // for 0 index
            result.append(" ")
            continue
        }
        result.append(sub)
        result.append(" ")
        start = end
    }
    val sub = s.substring(start, s.length)
    result.append(sub)

    return result.toString()
}
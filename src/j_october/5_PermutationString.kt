package j_october

/**
 *  Problem 5. Permutation in String
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
        Pair("ab", "eidbaooo"), Pair("ab", "eidboaoo")
    )

    testCases.forEach { test ->
        println("Result ==> ${checkInclusion(test.first, test.second)}")
    }

}

fun checkInclusion(s1: String, s2: String): Boolean {
    val chars1 = IntArray(26)
    val chars2 = IntArray(26)

    s1.forEach {
        chars1[it - 'a']++
    }

    var l = 0
    for (r in s2.indices) {
        chars2[s2[r] - 'a']++

        val count = r - l + 1
        if (count > s1.length) {
            chars2[s2[l] - 'a']--
            l++
        }

        if (chars1.contentEquals(chars2)) return true
    }

    return false
}
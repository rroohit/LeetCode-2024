package h_august

/**
 *  Problem 6. Minimum Number of Pushes to Type Word II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(NlogN)
 *
 *       - Space complexity: O(26)
 *
 * ## Code -
 */
fun main() {

     val testCases = listOf(
         "abcde",
         "xyzxyzxyzxyz",
         "aabbccddeeffgghhiiiiii"
     )

    testCases.forEach { word ->
        println("Result ==> ${minimumPushes(word)}")
    }

}

fun minimumPushes(word: String): Int {
    val mapCount = IntArray(26)
    word.forEach { ch -> mapCount[ch - 'a']++ }
    mapCount.sortDescending()
    var pushReq = 0
    mapCount.forEachIndexed { i, cnt ->
        pushReq += ((i / 8) + 1) * cnt
    }
    return pushReq
}
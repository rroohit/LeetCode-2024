package d_april

/**
 *  Problem 2. Isomorphic Strings
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

    val s = "aegg"
    val t = "aadd"

    println("Result ==> ${isIsomorphic(s, t)}")

}

fun isIsomorphic(s: String, t: String): Boolean {
    // ASCII element size is New - 256 (old - 128)
    val sMap = IntArray(256)
    val tMap = IntArray(256)

    // Because we are need to preserver the order of string.
    // After visiting each char in two string each char count in respective map will same.
    for (i in s.indices) {
        // If we visit where the count won't match means we are at the point of diff char->map pair.
        if (sMap[s[i].code] !=  tMap[t[i].code]) return false

        //
        sMap[s[i].code] = i + 1
        tMap[t[i].code] = i + 1
    }

    return true
}
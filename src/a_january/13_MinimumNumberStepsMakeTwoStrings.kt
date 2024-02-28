package a_january

/**
 *  Problem 13. Minimum Number of Steps to Make Two Strings
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

    val s = "leetcode"
    val t = "practice"

    println("Result ==> ${minSteps(s, t)}")

}
// not solved yet
fun minSteps(s: String, t: String): Int {
    val sFreq = freq(s)
    val tFreq = freq(t)

    var difference = 0
    for ((key, value) in sFreq) {
        val tt = tFreq.getOrDefault(key, 0)
        difference += (value - tt)
    }

    return difference
}

fun freq(s: String): HashMap<Char, Int> {
    val frequencies = HashMap<Char, Int>()
    for (char in s) {
        frequencies[char] = frequencies.getOrDefault(char, 0) + 1
    }
    return frequencies
}
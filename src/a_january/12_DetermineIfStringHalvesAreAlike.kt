package a_january

/**
 *  Problem = 12 : Determine if String Halves Are Alike
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n/2)
 *
 *      - Space complexity: O(1)
 *
 * # Code =>
 */
fun main() {

    val s = "book"

    val result = halvesAreAlike(s)

    println("Result ==> $result")

}

val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

fun halvesAreAlike(s: String): Boolean {
    var vL = 0
    var vR = 0

    var l = 0
    var r = s.length / 2

    while (r < s.length) {
        if (vowels.contains(s[l])) vL++
        if (vowels.contains(s[r])) vR++
        l++
        r++
    }

    return vL == vR
}
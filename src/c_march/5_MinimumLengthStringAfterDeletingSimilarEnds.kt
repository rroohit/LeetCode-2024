package c_march

/**
 *  Problem 5. Minimum Length of String After Deleting Similar Ends
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb" // 1

    println("Result ==> ${minimumLength(s)}")

}

// Algorithm - Two-Pointers
fun minimumLength(s: String): Int {
    val n = s.length
    var l = 0
    var r = s.length - 1

    while (l < r) {
        val curr = s[l]
        if (s[r] != curr) break
        while (l < n && l <= r && curr == s[l]) l++
        while (r > 0 && r >= l && curr == s[r]) r--
    }

    return (r - l) + 1
}
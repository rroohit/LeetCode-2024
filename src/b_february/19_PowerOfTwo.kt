package b_february

/**
 *  Problem 19. Power Of Two
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val n = 16

    println("Result ==> ${isPowerOfTwo(n)}")

}

fun isPowerOfTwo(n: Int): Boolean {
    if (n == 1) return true
    val nn= n.toLong()
    var pow = 2L
    while (pow <= nn) {
        if (pow == nn) return true
        pow *= 2
    }
    return false
}
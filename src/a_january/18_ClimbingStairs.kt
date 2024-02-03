package a_january

/**
 *  Problem = 18 : Climbing Stairs
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val n = 2

    val result = climbStairs(n)

    println("Result => $result")

}

// cache : num -> ways
val dp = hashMapOf<Int, Int>()

fun climbStairs(n: Int): Int {
    return findWays(0, n)
}

private fun findWays(nn: Int, n: Int): Int {
    if (nn > n) return 0
    if (dp.containsKey(nn)) return dp[nn]!!
    if (nn == n) return 1

    val result = findWays(nn + 1, n) + findWays(nn + 2, n)
    dp[nn] = result
    return result
}



fun climbStairs2(n: Int): Int {
    var one = 1
    var two = 1

    for (i in 0..<n - 1) {
        val temp = one
        one += two
        two = temp
    }

    return one
}
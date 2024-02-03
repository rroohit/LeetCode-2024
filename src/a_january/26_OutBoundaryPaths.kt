package a_january

/**
 *  Problem = 26 : Out of Boundary Paths
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n + m)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val m = 2
    val n = 2
    val maxMove = 2
    val startRow = 0
    val startColumn = 0

    val result = findPaths(m, n, maxMove, startRow, startColumn)

    println("Result ==> $result")

}


fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    return dfs(m, n, startRow, startColumn, maxMove).toInt()
}

val dp_cache = mutableMapOf<Triple<Int, Int, Int>, Long>()

fun dfs(m: Int, n: Int, r: Int, c: Int, mov: Int): Long {
    val mod = 1000000007

    if (r < 0 || r == m || c < 0 || c == n) {
        return 1
    }

    if (mov == 0) {
        return 0
    }

    val key = Triple(r, c, mov)
    if (key in dp_cache) {
        return dp_cache[key]!!
    }

    val result = ((dfs(m, n, r + 1, c, mov - 1) + dfs(m, n, r - 1, c, mov - 1)) % mod +
                    (dfs(m, n, r, c + 1, mov - 1) + dfs(m, n, r, c - 1, mov - 1)) + mod
            ) % mod

    dp_cache[key] = result
    return result
}
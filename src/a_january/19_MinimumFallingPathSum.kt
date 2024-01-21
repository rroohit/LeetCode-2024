package a_january

/**
 *  Problem = 19 : Minimum Falling Path Sum
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (n)
 *
 * # Code =>
 */
fun main() {

    val matrix = arrayOf(
        intArrayOf(2, 1, 3),
        intArrayOf(6, 5, 4),
        intArrayOf(7, 8, 9),
    )

    val result = minFallingPathSum(matrix)

    println("Result => $result")

}

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val n = matrix.size

    for (r in 1..<n) {
        for (c in 0..<n) {
            val mid = matrix[r - 1][c]
            val left = if (c > 0) matrix[r - 1][c - 1] else Int.MAX_VALUE
            val right = if (c < n - 1) matrix[r - 1][c + 1] else Int.MAX_VALUE
            matrix[r][c] = matrix[r][c] + minOf(mid, left, right)
        }
    }
    return matrix.last().min()
}

// cache : matrix[row,col] -> minValue
val cache = hashMapOf<Pair<Int, Int>, Int>()

fun minFallingPathSum2(matrix: Array<IntArray>): Int {
    val n = matrix.size

    var result = Int.MAX_VALUE

    for (c in 0..<n) {
        result = minOf(result, dfs(matrix, 0, c, n))
    }

    return result
}

private fun dfs(matrix: Array<IntArray>, row: Int, col: Int, n: Int): Int {
    if (row == n) return 0
    if (col == n || col < 0) return Int.MAX_VALUE
    if (cache.containsKey(Pair(row, col))) return cache.getOrDefault(Pair(row, col), 0)

    val result = matrix[row][col] + minOf(
        dfs(matrix, row + 1, col - 1, n),
        dfs(matrix, row + 1, col, n),
        dfs(matrix, row + 1, col + 1, n)
    )

    cache[Pair(row, col)] = result

    return result
}



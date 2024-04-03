package d_april

/**
 *  Problem 3. Word Search
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(N * M * 4^L)
 *          - N is the number of rows in the board.
 *          - M is the number of columns in the board.
 *          - L is the length of the word.
 *          - 4^L represents the branching factor of the depth-first search (DFS) algorithm.
 *              In each step of the DFS, there are at most 4 directions (up, down, left, right) to explore.
 *
 *       - Space complexity: O(L)
 *          - The space complexity is O(L), where L is the length of the word.
 *
 * ## Code -
 */
fun main() {

    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )

    val word = "ABCCED"

    println("Result ==> ${exist(board, word)}")

}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val row = board.size
    val col = board[0].size
    val path = mutableSetOf<Pair<Int, Int>>()

    fun dfs(r: Int, c: Int, i: Int): Boolean {
        if (i == word.length) {
            return true
        }

        if (r < 0 || c < 0 || r >= row || c >= col ||
            word[i] != board[r][c] || Pair(r, c) in path
        ) {
            return false
        }

        path.add(Pair(r, c))
        val res = (dfs(r + 1, c, i + 1) ||
                dfs(r - 1, c, i + 1) ||
                dfs(r, c + 1, i + 1) ||
                dfs(r, c - 1, i + 1))
        path.remove(Pair(r, c))
        return res
    }

    for (r in 0..<row) {
        for (c in 0..<col) {
            if (dfs(r, c, 0)) return true
        }
    }

    return false
}
















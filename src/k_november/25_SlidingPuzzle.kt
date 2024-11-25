package k_november


/**
 *  Problem 25. Sliding Puzzle.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O((m * n)! * (m * n)^2)
 *
 *       - Space complexity: O((m * n)!)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 0, 5)
        ),
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 0, 5)
        )
    )

    testCases.forEach { board ->
        println("Result ==> ${slidingPuzzle(board)}")
    }

}

private val directions = arrayOf(
    intArrayOf(1, 3),
    intArrayOf(0, 2, 4),
    intArrayOf(1, 5),
    intArrayOf(0, 4),
    intArrayOf(3, 5, 1),
    intArrayOf(4, 2),
)

fun slidingPuzzle(board: Array<IntArray>): Int {
    val startState = java.lang.StringBuilder()
    for (i in 0..1) {
        for (j in 0..2) {
            startState.append(board[i][j])
        }
    }

    val visited: MutableMap<String, Int> = HashMap()
    dfs(startState.toString(), visited, startState.indexOf("0"), 0)

    return visited.getOrDefault("123450", -1)
}

private fun dfs(
    state: String,
    visited: MutableMap<String, Int>,
    zeroPos: Int,
    moves: Int
) {
    if (visited.containsKey(state) && visited[state]!! <= moves) {
        return
    }
    visited[state] = moves

    for (nextPos in directions[zeroPos]) {
        val newState = swap(state, zeroPos, nextPos)
        dfs(newState, visited, nextPos, moves + 1)
    }
}

private fun swap(str: String, i: Int, j: Int): String {
    val sb = StringBuilder(str)
    sb.setCharAt(i, str[j])
    sb.setCharAt(j, str[i])
    return sb.toString()
}
package h_august

/**
 *  Problem 11. Minimum Number of Days to Disconnect Island
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(r * c)
 *
 *       - Space complexity: O(r * c)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
    )

    testCases.forEach { grid ->
        println("Result ==> ${minDays(grid)}")
    }


}

fun minDays(grid: Array<IntArray>): Int {
    val w = grid[0].size;
    val h = grid.size;
    var e = -1;
    var c = 0
    val ones = (0..<w * h).filter { grid[it / w][it % w] > 0 }
    val uf = IntArray(w * h) { it }
    fun find(a: Int): Int {
        while (uf[a] != uf[uf[a]]) uf[a] = uf[uf[a]]; return uf[a]
    }

    fun union(a: Int, b: Int) {
        if (find(a) != find(b)) {
            c--; uf[uf[a]] = uf[b]
        }
    }

    fun isDisconnected(): Boolean {
        for (i in ones) uf[i] = i; c = 0
        for (i in ones) if (i != e) {
            c++
            if (i % w > 0 && grid[i / w][i % w - 1] > 0 && i - 1 != e) union(i, i - 1)
            if (i / w > 0 && grid[i / w - 1][i % w] > 0 && i - w != e) union(i, i - w)
        }
        return c != 1
    }

    return if (isDisconnected()) 0 else if (ones.any { e = it; isDisconnected() }) 1 else 2
}
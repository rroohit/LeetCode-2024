package h_august

/**
 *  Problem 29.  Most Stones Removed with Same Row or Column
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2)
        )
    )

    testCases.forEach { stones ->
        println("Result ==> ${removeStones(stones)}")

    }


}

fun removeStones(stones: Array<IntArray>): Int {
    val n = stones.size
    var noOfRemovedStones = 0
    val adjList = Array(n) { mutableListOf<Int>() }

    repeat(n) { i -> // ith stone
        val x = stones[i][0]
        val y = stones[i][1]
        for (j in i + 1..<n) { // jth stone
            val jx = stones[j][0]
            val jy = stones[j][1]
            // if both ith and jth stones share same row or column need to add in adjList
            if (x == jx || y == jy) {
                adjList[i].add(j)
                adjList[j].add(i)
            }
        }
    }

    val visitedStones = BooleanArray(n)
    repeat(n) { stone ->
        if (!visitedStones[stone]) {
            dfsExploreAllStones(stone, adjList, visitedStones)
            noOfRemovedStones++
        }
    }

    return n - noOfRemovedStones
}

private fun dfsExploreAllStones(
    currStone: Int,
    adjList: Array<MutableList<Int>>,
    visitedStones: BooleanArray
) {
    if (visitedStones[currStone]) return
    visitedStones[currStone] = true

    // explore all nei connected stones
    val neiStones = adjList[currStone]
    for (nextStone in neiStones) {
        dfsExploreAllStones(nextStone, adjList, visitedStones)
    }
}
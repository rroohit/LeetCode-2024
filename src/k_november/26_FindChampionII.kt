package k_november

/**
 *  Problem 26. Find Champion II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            5, arrayOf(
                intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(4, 0)
            )
        ),
        Pair(
            4, arrayOf(
                intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 2)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${findChampion(test.first, test.second)}")
        println()
    }

}

fun findChampion(n: Int, edges: Array<IntArray>): Int {
    val isWeakTeam = BooleanArray(n)
    for ((u, v) in edges) {
        isWeakTeam[v] = true
    }

    var nonTempCount = 0
    var index = -1
    for (team in isWeakTeam.indices) {
        if (!isWeakTeam[team]) {
            nonTempCount++
            index = team
            if (nonTempCount > 1) return -1
        }
    }

    return index
}

fun findChampion1(n: Int, edges: Array<IntArray>): Int {
    val inDegree = IntArray(n)

    for (edge in edges) {
        inDegree[edge[1]]++
    }

    var champ = -1
    var champCount = 0

    for (i in 0..<n) {
        if (inDegree[i] == 0) {
            champCount++
            champ = i
        }
    }

    return if (champCount > 1) -1 else champ
}
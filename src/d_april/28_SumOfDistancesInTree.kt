package d_april

/**
 *  Problem 28. Sum of Distances in Tree
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(V + E)
 *          - V is the number of vertices/nodes
 *          - E is the number of edges.
 *
 *       - Space complexity: : O(V + E)
 *
 * ## Code -
 */
fun main() {
    val testCases = listOf(
        Pair(
            6, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 5)
            )
        )
    )

    testCases.forEach { test ->
        val n = test.first
        val edges = test.second
        println("Result ==> ${sumOfDistancesInTree(n, edges).toList()}")
    }

}

lateinit var graph: MutableMap<Int, MutableList<Int>>
lateinit var output: IntArray
lateinit var count: IntArray
var root = 0

fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
    graph = mutableMapOf()
    for ((s, t) in edges) {
        graph.getOrPut(s) { mutableListOf() }.add(t)
        graph.getOrPut(t) { mutableListOf() }.add(s)
    }

    output = IntArray(n) { 0 }
    count = IntArray(n) { 1 }

    dfs(0, -1, 0)

    dfs2(0, -1, root)

    return output
}

private fun dfs(cur: Int, parent: Int, depth: Int): Int {
    var o = 1
    if (graph[cur] != null) {
        for (child in graph[cur]!!) {
            if (child != parent) {
                o += dfs(child, cur, depth + 1)
                root += (depth + 1)
            }
        }
    }

    count[cur] = o
    return o
}

private fun dfs2(cur: Int, parent: Int, ansP: Int) {
    output[cur] = ansP
    if (graph[cur] == null) return
    for (child in graph[cur]!!) {
        if (child != parent) {
            dfs2(child, cur, ansP + (output.size - count[child]) - count[child])
        }
    }
}


























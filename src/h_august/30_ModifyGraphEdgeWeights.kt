package h_august

import g_july.INF

/**
 *  Problem 30. Modify Graph Edge Weights
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n^2)
 *          - where
 *              m is the number of Dijkstra runs, and
 *              n is the number of vertices.
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        GraphTestData(
            n = 5,
            edges = arrayOf(
                intArrayOf(4, 1, -1),
                intArrayOf(2, 0, -1),
                intArrayOf(0, 3, -1),
                intArrayOf(4, 3, -1)
            ),
            source = 0,
            destination = 1,
            target = 5
        )
    )

    testCases.forEach { graphTestData ->
        println(
            "Result ==> ${
                modifiedGraphEdges(
                    graphTestData.n,
                    graphTestData.edges,
                    graphTestData.source,
                    graphTestData.destination,
                    graphTestData.target
                ).map { it.toList() }
            }"
        )
    }

}

fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
    val graph = Array(n) { Array(n) { INF to false } }
    for ((from, to, weight) in edges) {
        graph[from][to] = if (weight != -1) weight to false else 1 to true
        graph[to][from] = graph[from][to].copy()
    }

    fun dijkstra(): DijktraStatus {
        val d = IntArray(n) { INF }
        val p = IntArray(n)
        val used = BooleanArray(n) { false }
        d[source] = 0
        repeat(n) {
            var v = -1
            for (j in 0..<n) {
                if (!used[j] && (v == -1 || d[j] < d[v])) {
                    v = j
                }
            }
            if (d[v] == INF) return@repeat
            used[v] = true
            for (j in 0..<n) {
                val (weight, isModified) = graph[v][j]
                if (weight == INF) continue
                if (d[v] + weight < d[j]) {
                    d[j] = d[v] + weight
                    p[j] = v
                }
            }
        }

        if (d[destination] == target) return DijktraStatus.OK

        if (d[destination] < target) {
            var v = destination
            val modifiableEdges = mutableListOf<Pair<Int, Int>>()
            while (v != source) {
                if (graph[p[v]][v].second) {
                    modifiableEdges += p[v] to v
                }
                v = p[v]
            }
            if (modifiableEdges.isNotEmpty()) {
                val (from, to) = modifiableEdges.first()
                val modifyWeight = target - d[destination] + 1
                graph[from][to] = modifyWeight to false
                graph[to][from] = graph[from][to].copy()
                return DijktraStatus.CONTINUE
            }
            return DijktraStatus.FAIL
        }

        return DijktraStatus.FAIL
    }

    var status: DijktraStatus
    do {
        status = dijkstra()
    } while (status == DijktraStatus.CONTINUE)

    if (status == DijktraStatus.OK) {
        val ans = mutableListOf<IntArray>()
        for (i in 0..<n) {
            for (j in (i + 1)..<n) {
                if (graph[i][j].first != INF) {
                    ans += intArrayOf(i, j, graph[i][j].first)
                }
            }
        }
        return ans.toTypedArray()
    }

    return arrayOf()
}

private enum class DijktraStatus { CONTINUE, OK, FAIL }

private data class GraphTestData(
    val n: Int,
    val edges: Array<IntArray>,
    val source: Int,
    val destination: Int,
    val target: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GraphTestData

        if (n != other.n) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (destination != other.destination) return false
        if (target != other.target) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + destination
        result = 31 * result + target
        return result
    }
}
package h_august

/**
 *  Problem 27. Path with Maximum Probability
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(E LogE)
 *
 *       - Space complexity: O(E + V)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        TestData31(
            n = 3,
            edges = arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(0, 2)
            ),
            succProb = doubleArrayOf(0.5, 0.5, 0.2),
            startNode = 0,
            endNode = 2
        )
    )

    testCases.forEach { testData ->
        println(
            "Result ==> ${
                maxProbability(
                    testData.n,
                    testData.edges,
                    testData.succProb,
                    testData.startNode,
                    testData.endNode
                )
            }"
        )

    }

}

// TC - O(N^2) :: SC - O(N)
fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, startNode: Int, endNode: Int): Double {
    val maxProb = DoubleArray(n)
    maxProb[startNode] = 1.0

    for (i in 0..<n) {
        var isUpdated = false
        for (j in edges.indices) {
            val u = edges[j][0]
            val v = edges[j][1]
            val pathProb = succProb[j]
            if (maxProb[u] * pathProb > maxProb[v]) {
                maxProb[v] = maxProb[u] * pathProb
                isUpdated = true
            }
            if (maxProb[v] * pathProb > maxProb[u]) {
                maxProb[u] = maxProb[v] * pathProb
                isUpdated = true
            }
        }
        if (!isUpdated) break
    }

    return maxProb[endNode]
}

private data class TestData31(
    val n: Int,
    val edges: Array<IntArray>,
    val succProb: DoubleArray,
    val startNode: Int,
    val endNode: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData31

        if (n != other.n) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (!succProb.contentEquals(other.succProb)) return false
        if (startNode != other.startNode) return false
        if (endNode != other.endNode) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + succProb.contentHashCode()
        result = 31 * result + startNode
        result = 31 * result + endNode
        return result
    }
}
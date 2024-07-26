package g_july

/**
 *  Problem 16. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        CityDetails(
            n = 4,
            edges = arrayOf(
                intArrayOf(0, 1, 3),
                intArrayOf(1, 2, 1),
                intArrayOf(1, 3, 4),
                intArrayOf(2, 3, 1)
            ),
            distanceThreshold = 4
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${findTheCity(test.n, test.edges, test.distanceThreshold)}")
    }

}

fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    val dist = Array(n) { IntArray(n) { Int.MAX_VALUE / 2 } } // Use INT_MAX / 2 to prevent overflow
    for (i in 0..<n) {
        dist[i][i] = 0
    }

    for (edge in edges) {
        val u = edge[0]
        val v = edge[1]
        val w = edge[2]
        dist[u][v] = w
        dist[v][u] = w
    }

    for (k in 0..<n) {
        for (i in 0..<n) {
            for (j in 0..<n) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j]
                }
            }
        }
    }

    var minReachableCities = Int.MAX_VALUE
    var resultCity = -1

    for (i in 0..<n) {
        var reachableCities = 0
        for (j in 0..<n) {
            if (i != j && dist[i][j] <= distanceThreshold) {
                reachableCities++
            }
        }
        if (reachableCities < minReachableCities || (reachableCities == minReachableCities && i > resultCity)) {
            minReachableCities = reachableCities
            resultCity = i
        }
    }

    return resultCity
}

private data class CityDetails(
    val n: Int,
    val edges: Array<IntArray>,
    val distanceThreshold: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CityDetails

        if (n != other.n) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (distanceThreshold != other.distanceThreshold) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + distanceThreshold
        return result
    }
}
package l_december


/**
 *  Problem 21. Maximum Number of K-Divisible Components.
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
        TestData21(
            5,
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4)),
            intArrayOf(1, 8, 1, 4, 4),
            6
        )
    )

    testCases.forEach { testData21 ->
        println(
            "Result ==> ${
                maxKDivisibleComponents(
                    testData21.n,
                    testData21.edges,
                    testData21.values,
                    testData21.k
                )
            }"
        )
    }

}

fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
    val adjList: Array<MutableList<Int>> = Array(n) { mutableListOf() }
    for (i in 0..<n) {
        adjList[i] = ArrayList()
    }
    for (edge in edges) {
        val node1 = edge[0]
        val node2 = edge[1]
        adjList[node1].add(node2)
        adjList[node2].add(node1)
    }

    val componentCount = IntArray(1) // Use array to pass by reference

    dfs(0, -1, adjList, values, k, componentCount)

    return componentCount[0]
}

internal fun dfs(
    currentNode: Int,
    parentNode: Int,
    adjList: Array<MutableList<Int>>,
    nodeValues: IntArray,
    k: Int,
    componentCount: IntArray
): Int {
    var sum = 0

    for (neighborNode in adjList[currentNode]) {
        if (neighborNode != parentNode) {
            sum += dfs(
                neighborNode,
                currentNode,
                adjList,
                nodeValues,
                k,
                componentCount
            )
            sum %= k
        }
    }

    sum += nodeValues[currentNode]
    sum %= k

    if (sum == 0) {
        componentCount[0]++
    }

    return sum
}

private data class TestData21(
    val n: Int,
    val edges: Array<IntArray>,
    val values: IntArray,
    val k: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData21

        if (n != other.n) return false
        if (k != other.k) return false
        if (!edges.contentDeepEquals(other.edges)) return false
        if (!values.contentEquals(other.values)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = n
        result = 31 * result + k
        result = 31 * result + edges.contentDeepHashCode()
        result = 31 * result + values.contentHashCode()
        return result
    }
}
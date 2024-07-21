package g_july

/**
 *  Problem 21. Build a Matrix With Conditions
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(k + E)
 *          - where k is the number of vertices (or elements) and E is the number of edges/conditions
 *
 *       - Space complexity: O(K ^ 2)
 *          - k is result matrix
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        MatrixData(
            k = 3,
            rowConditions = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 2)
            ),
            colConditions = arrayOf(
                intArrayOf(2, 1),
                intArrayOf(3, 2)
            )
        )
    )


    testCases.forEach { testData ->
        val result = buildMatrix(testData.k, testData.rowConditions, testData.colConditions)
        result.forEach { arr ->
            println(arr.toList())
        }
        println()
    }


}

fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
    val rowOrder = topologicalSort(k, rowConditions)
    val colOrder = topologicalSort(k, colConditions)
    if (rowOrder.isEmpty() || colOrder.isEmpty()) return emptyArray()

    val mapRowInd = HashMap<Int, Int>()
    val mapColInd = HashMap<Int, Int>()
    rowOrder.forEachIndexed { index, num -> mapRowInd[num] = index }
    colOrder.forEachIndexed { index, num -> mapColInd[num] = index }

    val result = Array(k) { IntArray(k) { 0 } }
    for (num in 1..k) {
        val r = mapRowInd[num]
        val c = mapColInd[num]
        result[r!!][c!!] = num
    }
    return result
}

private fun topologicalSort(k: Int, edges: Array<IntArray>): List<Int> {
    val adjList = HashMap<Int, MutableList<Int>>()
    for ((src, dst) in edges) {
        adjList.computeIfAbsent(src) { mutableListOf() }.add(dst)
    }
    val order = mutableListOf<Int>()
    val visit = HashSet<Int>()
    val path = HashSet<Int>()
    for (src in 1..k) {
        if (!dfsFillOrder(src, adjList, visit, path, order)) {
            return mutableListOf()
        }
    }
    return order.reversed()
}

private fun dfsFillOrder(
    src: Int,
    adjList: HashMap<Int, MutableList<Int>>,
    visit: HashSet<Int>,
    path: HashSet<Int>,
    order: MutableList<Int>
): Boolean {
    if (src in path) return false
    if (src in visit) return true

    visit.add(src)
    path.add(src)

    val neighbours = adjList[src] ?: mutableListOf()
    for (nei in neighbours) {
        if(!dfsFillOrder(nei, adjList, visit, path, order)) return false
    }
    path.remove(src)
    order.add(src)
    return true
}


private data class MatrixData(
    val k: Int,
    val rowConditions: Array<IntArray>,
    val colConditions: Array<IntArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MatrixData

        if (k != other.k) return false
        if (!rowConditions.contentDeepEquals(other.rowConditions)) return false
        if (!colConditions.contentDeepEquals(other.colConditions)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = k
        result = 31 * result + rowConditions.contentDeepHashCode()
        result = 31 * result + colConditions.contentDeepHashCode()
        return result
    }
}
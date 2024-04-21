package d_april

import java.util.*

/**
 *  Problem 21. Find if Path Exists in Graph
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
        TestData(
            n = 3,
            edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0)),
            source = 0,
            destination = 2
        ),
        TestData(
            n = 6,
            edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(3, 5), intArrayOf(5, 4), intArrayOf(4, 3)),
            source = 0,
            destination = 5
        )
    )

    testCases.forEach {
        val result = validPath(it.n, it.edges, it.source, it.destination)
        println("Result ==> $result")
    }

}

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val visited = BooleanArray(n) { false }
    val queue: Queue<Int> = LinkedList()
    queue.add(source)
    visited[source] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()!!
        if (curr == destination) return true
        for (i in edges.indices) {
            val (u, v) = edges[i]
            if (u == curr && !visited[v]) {
                queue.offer(v)
                visited[v] = true
            }
            if (v == curr && !visited[u]) {
                queue.offer(u)
                visited[u] = true
            }
        }
    }

    return false
}


data class TestData(
    val n: Int,
    val edges: Array<IntArray>,
    val source: Int,
    val destination: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData

        if (!edges.contentDeepEquals(other.edges)) return false
        if (n != other.n) return false
        if (source != other.source) return false
        if (destination != other.destination) return false

        return true
    }

    override fun hashCode(): Int {
        var result = edges.contentDeepHashCode()
        result = 31 * result + n
        result = 31 * result + source
        result = 31 * result + destination
        return result
    }
}
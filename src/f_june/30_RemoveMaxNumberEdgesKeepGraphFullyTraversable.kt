package f_june

/**
 *  Problem 30. Remove Max Number of Edges to Keep Graph Fully Traversable
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(M * Alpha(N))
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {
    val testCases = listOf(
        Pair(
            4,
            arrayOf(
                intArrayOf(3, 1, 2),
                intArrayOf(3, 2, 3),
                intArrayOf(1, 1, 3),
                intArrayOf(1, 2, 4),
                intArrayOf(1, 1, 2),
                intArrayOf(2, 3, 4)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxNumEdgesToRemove(test.first, test.second)}")
    }

}

fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
    val bob = DisjoinSet(n + 1)
    val alice = DisjoinSet(n + 1)

    var edgesNeeded = 0
    for ((type, src, dest) in edges) {
        if (type == EdgeType.BOTH.value) {
            val aliceNeed = alice.union(src, dest)
            val bobNeed = bob.union(src, dest)
            edgesNeeded += if (aliceNeed || bobNeed) 1 else 0
        }
    }

    for ((type, src, dest) in edges) {
        if (type == EdgeType.ALICE.value) {
            edgesNeeded += if (alice.union(src, dest)) 1 else 0
        } else if (type == EdgeType.BOB.value) {
            edgesNeeded += if (bob.union(src, dest)) 1 else 0
        }
    }

    if (bob.components > 2 || alice.components > 2) {  // Dummy node 0 unconnected
        return -1
    }

    return edges.size - edgesNeeded
}


class DisjoinSet(val size: Int) {
    val parents = IntArray(size){ it }
    val ranks = IntArray(size){ 1 }
    var components = size
        private set

    fun find(x: Int): Int {
        if (parents[x] != x) {
            parents[x] = find(parents[x])
        }
        return parents[x]
    }

    fun union(a: Int, b: Int): Boolean {
        var rootA = find(a)
        var rootB = find(b)
        if (rootA == rootB) {
            return false
        }

        if (ranks[rootA] < ranks[rootB]) {
            rootA = rootB.also { rootB = rootA }
        }
        parents[rootB] = rootA

        if (ranks[rootA] == ranks[rootB]) {
            ranks[rootA] += 1
        }
        components -= 1

        return true
    }
}

enum class EdgeType(val value: Int) {
    ALICE(1),
    BOB(2),
    BOTH(3),
}


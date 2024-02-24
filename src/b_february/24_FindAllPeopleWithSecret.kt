package b_february

/**
 *  Problem 24. Find All People With Secret
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

    val n = 6
    val firstPerson = 1
    val meetings = arrayOf(
        intArrayOf(1, 2, 5),
        intArrayOf(2, 3, 8),
        intArrayOf(1, 5, 10),
    )

    val result = findAllPeople(n, meetings, firstPerson)

    println("Result ==> $result")

}

fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val secr = mutableSetOf(0, firstPerson)
    val tMap = mutableMapOf<Int, MutableMap<Int, MutableList<Int>>>()

    // Preprocess meetings data
    for ((src, dst, t) in meetings) {
        tMap.computeIfAbsent(t) { mutableMapOf() }
        tMap[t]!!.computeIfAbsent(src) { mutableListOf() }.add(dst)
        tMap[t]!!.computeIfAbsent(dst) { mutableListOf() }.add(src)
    }

    // Depth-first search
    fun dfs(src: Int, adj: MutableMap<Int, MutableList<Int>>) {
        val visit = mutableSetOf<Int>()
        val stack = mutableListOf(src)
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(stack.size - 1)
            if (node !in visit) {
                visit.add(node)
                secr.add(node)
                adj[node]?.forEach { nei ->
                    stack.add(nei)
                }
            }
        }
    }

    // Traverse meetings by timestamp
    tMap.keys.sorted().forEach { t ->
        tMap[t]!!.keys.filter { it in secr }.forEach { src ->
            dfs(src, tMap[t]!!)
        }
    }

    return secr.toList()
}
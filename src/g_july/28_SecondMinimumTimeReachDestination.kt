package g_july

/**
 *  Problem 28. Second Minimum Time to Reach Destination
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


}

fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
    val g = mutableMapOf<Int, MutableList<Int>>()
    for ((u, v) in edges) {
        g.getOrPut(u) { mutableListOf() } += v
        g.getOrPut(v) { mutableListOf() } += u
    }
    val q = ArrayDeque<Int>();
    val s = IntArray(n + 1) { -1 }
    q += 1
    var found = 0
    var totalTime = 0
    while (q.size > 0) {
        repeat(q.size) {
            val c = q.removeFirst()
            if (c == n && found++ > 0) return totalTime
            g[c]?.forEach {
                if (s[it] != totalTime) {
                    s[it] = totalTime; q += it
                }
            }
        }
        totalTime += time + ((totalTime / change) % 2) * (change - (totalTime % change))
    }
    return totalTime
}
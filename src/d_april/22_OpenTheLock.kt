package d_april

import java.util.*

/**
 *  Problem 22. Open the Lock
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:  O(N + L),
 *          where N is the number of combinations and L is the number of deadends.
 *
 *       - Space complexity: O(N + L)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("0202", arrayOf("0201", "0101", "0102", "1212", "2002")),
        Pair("0009", arrayOf("8888")),
        Pair("8888", arrayOf("0000")),
        Pair("8888", arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"))
    )

    testCases.forEachIndexed { index, pair ->
        val target = pair.first
        val deadends = pair.second

        println("Result $index ==> ${openLock(deadends, target)}")

    }


}

private val visited = HashSet<String>()
private val queue: Queue<Pair<String, Int>> = LinkedList()

fun openLock(deadends: Array<String>, target: String): Int {
    visited.clear()
    queue.clear()
    visited.addAll(deadends)
    if (deadends.contains("0000")) return -1

    queue.offer(Pair("0000", 0))

    while (queue.isNotEmpty()) {
        val (comb, depth) = queue.poll()
        if (comb == target) return depth

        for (child in getChildCom(comb)) {
            if (!visited.contains(child)) {
                visited.add(child)
                queue.offer(Pair(child, depth + 1))
            }
        }
    }

    return -1
}

private fun getChildCom(currCom: String): List<String> {
    val combinations = mutableListOf<String>()

    for ((i, ch) in currCom.withIndex()) {
        val num = (ch.digitToInt() + 1) % 10
        val str1 = currCom.substring(0, i) + num + currCom.substring(i + 1)
        // println(str1)
        combinations.add(str1)
        val num2 = ((ch.digitToInt() - 1) + 10) % 10
        val str2 = currCom.substring(0, i) + num2 + currCom.substring(i + 1)
        combinations.add(str2)
    }
    return combinations
}
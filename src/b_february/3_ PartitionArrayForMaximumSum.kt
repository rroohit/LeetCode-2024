package b_february

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem = 3 : Partition Array for Maximum Sum
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val arr = intArrayOf(1, 15, 7, 9, 2, 5, 10)
    val k = 3

    val result = maxSumAfterPartitioning(arr, k)

    println("Result ==> $result")

}

fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    return dfs(arr, 0, k)
}

private val cache = mutableMapOf<Int, Int>()
private fun dfs(arr: IntArray, i: Int, k: Int): Int {
    if (i >= arr.size) return 0
    if (cache.containsKey(i)) return cache[i]!!

    var res = 0
    var max = 0
    for (j in i..<min(i + k, arr.size)) {
        max = max(max, arr[j])
        val windowSize = j - i + 1
        res = max(res, dfs(arr, j + 1, k) + max * windowSize)
    }
    cache[i] = res
    return res
}

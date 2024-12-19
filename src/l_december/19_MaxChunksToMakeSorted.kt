package l_december

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 19. Max Chunks To Make Sorted.
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
        intArrayOf(4, 3, 2, 1, 0),
        intArrayOf(1, 0, 2, 3, 4)
    )

    testCases.forEach { arr ->
        println("Result ==> ${maxChunksToSorted(arr)}")
    }

}

fun maxChunksToSorted(arr: IntArray): Int {
    val n = arr.size
    val prefixMax = arr.clone()
    val suffixMin = arr.clone()

    for (i in 1..<n) {
        prefixMax[i] = max(prefixMax[i - 1].toDouble(), prefixMax[i].toDouble()).toInt()
    }

    for (i in n - 2 downTo 0) {
        suffixMin[i] = min(suffixMin[i + 1].toDouble(), suffixMin[i].toDouble()).toInt()
    }

    var chunks = 0
    for (i in 0..<n) {
        if (i == 0 || suffixMin[i] > prefixMax[i - 1]) {
            chunks++
        }
    }

    return chunks
}
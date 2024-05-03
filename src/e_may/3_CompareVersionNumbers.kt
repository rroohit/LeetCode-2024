package e_may

import kotlin.math.max

/**
 *  Problem 3. Compare Version Numbers
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(max(m, n))
 *          - where m and n are the lengths of the input version strings.
 *
 *       - Space complexity: O(m + n)
 *          - where m and n are the lengths of the input version strings.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("1.01", "1.001"),
        Pair("1.0", "1.0.0"),
        Pair("0.1", "1.1")
    )

    testCases.forEach { test ->
        val version1 = test.first
        val version2 = test.second
        println("Result => ${compareVersion(version1, version2)}")
    }


}

fun compareVersion(version1: String, version2: String): Int {
    val list1 = version1.split(".").map { it.toInt() }
    val list2 = version2.split(".").map { it.toInt() }

    val last = max(list1.size, list2.size)

    for (i in 0..<last) {
        val inV1 = if (i >= list1.size) 0 else list1[i]
        val inV2 = if (i >= list2.size) 0 else list2[i]
        if (inV1 == inV2) continue

        return if (inV1 > inV2) 1 else -1
    }

    return 0
}
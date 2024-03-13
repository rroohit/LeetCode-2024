package c_march

/**
 *  Problem 13. Find the Pivot Integer
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val n = 8

    val result = pivotInteger(n)

    println("Result => $result")

}

fun pivotInteger(n: Int): Int {
    val prefixSum = IntArray(n + 1)

    for (i in 1..n) {
        prefixSum[i] = prefixSum[i - 1] + i
    }

    val last = prefixSum.last()

    for (i in 1..n) {
        val curr = prefixSum[i]
        val req = (last - curr) + i
        if (curr == req) return i
    }

    return -1
}
package a_january

import kotlin.math.min

/**
 *  Problem = 20 : Sum of Subarray Minimums
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n^2)
 *
 *      - Space complexity: O(1)
 *
 * # Code =>
 */
fun main() {

    val arr = intArrayOf(3, 1, 2, 4)

    val result = sumSubarrayMins(arr)

    println("Result ==> $result")

}

private val MOD = 1000000007

fun sumSubarrayMins(arr: IntArray): Int {
    var result = 0L
    val len = arr.size

    for (i in 0..<len) {
        var curr = arr[i]
        result = (result + curr)

        for (j in (i + 1) ..< len) {
            curr = min(curr, arr[j])
            result = (result + curr)
        }

    }

    return (result % MOD).toInt()
}
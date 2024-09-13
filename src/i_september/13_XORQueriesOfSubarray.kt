package i_september

/**
 *  Problem 13. XOR Queries of a Subarray
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N + Q)
 *              - n building prefix xor array
 *              - q no of queries
 *
 *       - Space complexity: O(N)
 *              - prefix xor array
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 4, 8),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(0, 3),
                intArrayOf(3, 3)
            )
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${xorQueries(test.first, test.second).toList()}")
    }

}

fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
    val prefXor = IntArray(arr.size + 1)
    for (i in arr.indices) {
        prefXor[i + 1] = prefXor[i] xor arr[i]
    }

    val result = IntArray(queries.size)
    for (i in queries.indices) {
        result[i] = prefXor[queries[i][1] + 1] xor prefXor[queries[i][0]]
    }

    return result
}


//  Iterative Approach :: TC - O(q * n) :: SC - O(1)
fun xorQueries1(arr: IntArray, queries: Array<IntArray>): IntArray {
    val result = IntArray(queries.size)
    for (i in queries.indices) {
        var sum = 0
        for (j in queries[i][0]..queries[i][1]) {
            sum = sum xor arr[j]
        }
        result[i] = sum
    }
    return result
}
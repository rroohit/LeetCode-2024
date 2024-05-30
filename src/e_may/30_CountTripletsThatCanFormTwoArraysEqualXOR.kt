package e_may

/**
 *  Problem 30. Count Triplets That Can Form Two Arrays of Equal XOR
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

    val testCases = listOf(
        intArrayOf(2, 3, 1, 6, 7),
        intArrayOf(1, 1, 1, 1, 1)
    )

    testCases.forEach { arr ->
        println("Result ==> ${countTriplets(arr)}")
    }

}

fun countTriplets(arr: IntArray): Int {
    val len = arr.size
    var count = 0

    for (i in 0..<len) {
        var a = 0

        for (j in i + 1 ..<len) {
            a = a xor arr[j - 1]
            var b = 0

            for (k in j..< len) {
                b = b xor arr[k]
                if (a == b) count++
            }

        }
    }

    return count
}
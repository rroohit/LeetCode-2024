package d_april

/**
 *  Problem 24. N-th Tribonacci Number
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

    val testCases = listOf(4, 5, 25, 73)

    for (n in testCases) {
        println("Result ==> ${tribonacci(n)}")
    }

}

fun tribonacci(n: Int): Int {
    val arr = IntArray(100) { 0 }
    arr[1] = 1
    arr[2] = 1

    if (n > 2) {
        for (i in 3..< arr.size) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3]
            if (i == n) break
        }
    }

    return arr[n]
}

package a_january

//
/**
 *  Problem = 27 : K-Inverse Pairs Array
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n + m)
 *
 *      - Space complexity: (n)
 *
 * # Code =>
 */
fun main() {

    val n = 3
    val k = 1

    println("Result ==> ${kInversePairs(n, k)}")

}


fun kInversePairs(n: Int, k: Int): Int {
    val mod = 1000000007
    var prev = IntArray(k + 1) { 0 }
    prev[0] = 1

    for (N in 1..n ) {
        val curr = IntArray(k + 1) { 0 }
        var total = 0L
        for (K in 0..k ) {
            if (K >= N) {
                total -= prev[K - N]
            }
            total = (total + prev[K]) % mod
            curr[K] = total.toInt()
        }
        prev = curr
    }
    return prev[k]
}
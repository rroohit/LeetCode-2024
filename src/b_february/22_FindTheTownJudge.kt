package b_february

/**
 *  Problem 22. Find The Town Judge
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

    val n = 3
    val trust = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 1),
    )

    println("Result ==> ${findJudge(n, trust)}")

}

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val inDegrees = IntArray(n + 1)
    val outDegrees = IntArray(n + 1)

    for ((a, b) in trust) {
        inDegrees[b]++
        outDegrees[a]++
    }

    // judge trusts no one
    val judgeCandidates = mutableSetOf<Int>()
    for (i in 1..<outDegrees.size) {
        if (outDegrees[i] == 0) {
            judgeCandidates.add(i)
        }
    }

    // everyone trusts the judge
    for (candidate in judgeCandidates) {
        if (inDegrees[candidate] == n - 1) {
            return candidate
        }
    }
    return -1
}
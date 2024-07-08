package g_july

/**
 *  Problem 8. Find the Winner of the Circular Game
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
        Pair(5, 2),
        Pair(3, 1),

    )
    println((5 % 5) - 1)

    testCases.forEach { test ->
        println("Result ==> ${findTheWinner(test.first, test.second)}")
    }


}

fun findTheWinner1(n: Int, k: Int): Int {
    val students = IntArray(n) { 1 }
    var curSum = n
    var curInd = 0
    var removalInd = 0

    while (curSum > 1) {
        var cnt = 0
        while (cnt < k) {
            removalInd = ((curInd + 1) % n) - 1
            if (students[removalInd] == 1) cnt++
            curInd++
        }
        if (students[removalInd] == 1) {
            students[removalInd] = -1
            curSum--
        }
    }

    for ((i, j) in students.withIndex()){
        if (j == 1) return i + 1
    }
    return -1
}

fun findTheWinner(n: Int, k: Int): Int {
    return if (n == 1) 1 else ((findTheWinner(n - 1, k) + k -1) % n) + 1
}

package j_october

/**
 *  Problem 1. Check If Array Pairs Are Divisible by k
 *
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

    val testCases = listOf(
        Pair(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5)
    )

    testCases.forEach { test ->
        println("Result ==> ${canArrange(test.first, test.second)}")
    }

}

fun canArrange(arr: IntArray, k: Int): Boolean {
    val remCount = HashMap<Int, Int>()
    for (num in arr) {
        val rem = (num % k + k) % k
        remCount[rem] = remCount.getOrDefault(rem, 0) + 1
    }

    for (num in arr) {
        val rem = (num % k + k) % k
        if (rem == 0 && (remCount[rem]!! % 2) == 1) return false
        if (rem != 0 && remCount[rem]!! != remCount.getOrDefault(k  - rem, 0)) return false
    }

    return true
}
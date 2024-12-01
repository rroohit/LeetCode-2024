package l_december

/**
 *  Problem 1. Check If N and Its Double Exist.
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
        intArrayOf(10, 2, 5, 3),
        intArrayOf(3, 1, 7, 11),
        intArrayOf(7, 1, 14, 11),
    )

    testCases.forEach { arr ->
        println("Result ==> ${checkIfExist(arr)}")
    }

}

fun checkIfExist(arr: IntArray): Boolean {
    val seen = HashSet<Int>()
    for (num in arr) {
        if (seen.contains(num * 2) ||
            (num % 2 == 0 && seen.contains(num / 2))
        ) return true
        seen.add(num)
    }
    return false
}

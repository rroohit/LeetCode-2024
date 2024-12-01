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
        intArrayOf(-2, 0, 10, -19, 4, 6, -8)
    )

    testCases.forEach { arr ->
        println("Result ==> ${checkIfExist(arr)}")
    }

}

fun checkIfExist(arr: IntArray): Boolean {
    arr.sort()
    for (i in arr.indices) {
        val num = arr[i] * 2
        val ind = arr.isNumExistInd(num)
        if (ind >= 0 && ind != i) return true
    }
    return false
}

private fun IntArray.isNumExistInd(target: Int): Int {
    var l = 0
    var r = size - 1
    while (l <= r) {
        val m = (l + r) / 2
        if (get(m) == target) return m
        if (get(m) < target) l = m + 1 else r = m - 1
    }
    return -1
}


// Brute Force : TC - O(n) : SC - O(n)
fun checkIfExist1(arr: IntArray): Boolean {
    val seen = HashSet<Int>()
    for (num in arr) {
        if (seen.contains(num * 2) ||
            (num % 2 == 0 && seen.contains(num / 2))
        ) return true
        seen.add(num)
    }
    return false
}

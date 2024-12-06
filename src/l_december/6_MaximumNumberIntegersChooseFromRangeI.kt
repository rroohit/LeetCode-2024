package l_december

/**
 *  Problem 6. Maximum Number of Integers to Choose From a Range I.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(b + n)
 *
 *       - Space complexity: O(b)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(intArrayOf(1, 6, 5), 5, 6)
    )

    testCases.forEach { test ->
        println("Result ==> ${maxCount(test.first, test.second, test.third)}")
    }

}

fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
    val banSet = HashSet<Int>()
    for (num in banned) if (num <= n) banSet.add(num)

    var count = 0
    var currSum = maxSum
    for (num in 1..n) {
        if (banSet.contains(num)) continue
        if (currSum - num < 0) break
        count++
        currSum -= num
    }

    return count
}
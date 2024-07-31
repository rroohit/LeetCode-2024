package g_july

/**
 *  Problem 31. Filling Bookcase Shelves
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 3),
                intArrayOf(2, 3),
                intArrayOf(1, 1),
                intArrayOf(1, 1),
                intArrayOf(1, 1),
                intArrayOf(1, 2),
            ),
            4
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minHeightShelves(test.first, test.second)}")
    }

}

fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
    val dp = IntArray(books.size + 1)
    for (i in 1..books.size) {
        var min = dp[i - 1] + books[i - 1][1]
        var height = books[i - 1][1]
        var width = books[i - 1][0]
        var j = i - 2
        while (j >= 0 && width + books[j][0] <= shelfWidth) {
            width += books[j][0]
            height = maxOf(height, books[j][1])
            min = minOf(min, height + dp[j])
            j--
        }
        dp[i] = min
    }
    return dp[books.size]
}
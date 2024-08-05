package h_august

/**
 *  Problem 5. Kth Distinct String in an Array
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
        Pair(
            arrayOf("d", "b", "c", "b", "c", "a"),
            2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${kthDistinct(test.first, test.second)}")
    }

}

fun kthDistinct(arr: Array<String>, k: Int): String {
    val map = HashMap<String, Int>()
    for (str in arr) {
        map[str] = map.getOrDefault(str, 0) + 1
    }
    var count = k
    for (str in arr) {
        val currCount = map[str]
        if (currCount == 1) {
            if (count == 1) return str
            count--
        }
    }
    return ""
}
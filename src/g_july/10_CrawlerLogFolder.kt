package g_july

/**
 *  Problem 10. Crawler Log Folder
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("d1/", "d2/", "../", "d21/", "./"),
        arrayOf("d1/", "d2/", "./", "d3/", "../", "d31/"),
        arrayOf("d1/", "../", "../", "../")
    )

    testCases.forEach { logs ->
        println("Result ==> ${minOperations(logs)}")
    }

}

fun minOperations(logs: Array<String>): Int {
    var depth = 0
    for (log in logs) {
        if (log == "./") continue
        if (log == "../") {
            if (depth > 0) depth--
        } else {
            depth++
        }
    }
    return depth
}
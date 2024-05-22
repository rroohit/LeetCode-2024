package e_may

/**
 *  Problem 22. Palindrome Partitioning
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * 2^n)
 *
 *       - Space complexity: O(n * 2^n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "aab",
        "a"
    )

    testCases.forEach { s ->
        println("Result ==> ${partition(s)}")
    }

}

private val listOfPartitions = mutableListOf<List<String>>()
fun partition(s: String): List<List<String>> {
    listOfPartitions.clear()
    dfsPartitionBuilder(0, s, mutableListOf())
    return listOfPartitions
}

private fun dfsPartitionBuilder(curInd: Int, s: String, subPart: MutableList<String>) { // n
    // Base case
    if (curInd >= s.length) {
        listOfPartitions.add(subPart.toList())
        return
    }

    for (nextInd in curInd ..< s.length) { // n
        val subStr = s.substring(curInd, nextInd + 1)
        if (subStr.isPalindrome()) {
            subPart.add(subStr)
            dfsPartitionBuilder(nextInd + 1, s, subPart)

            subPart.removeLastOrNull() // Backtracking
        }
    }
}

private fun String.isPalindrome(): Boolean {
    var (l, r) = Pair(0, length - 1)
    while (l < r) if (get(l++) != get(r--)) return false
    return true
}
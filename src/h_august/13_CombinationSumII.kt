package h_august

/**
 *  Problem 13. Combination Sum II
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

    val testCases = listOf(
        Pair(
            intArrayOf(10, 1, 2, 7, 6, 1, 5),
            8
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${combinationSum2(test.first, test.second)}")
    }

}

private val result = mutableListOf<List<Int>>()
private val combination = mutableListOf<Int>()

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    dfs(candidates, target)
    return result
}

private fun dfs(candidates: IntArray, target: Int, index: Int = 0) {
    if (target == 0) {
        val list = combination.toList()
        result.add(list)
    } else {
        var last = 1_000_000
        for (i in index..<candidates.size) {
            if (candidates[i] == last) continue
            if (candidates[i] > target) break
            combination.add(candidates[i])
            dfs(candidates, target - candidates[i], i + 1)
            last = combination.removeLast()
        }
    }
}
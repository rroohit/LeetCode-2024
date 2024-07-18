package g_july

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 18. Number of Good Leaf Nodes Pairs
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            listOf(1, 2, 3, null, 4),
            3
        )
    )

    testCases.forEach { test ->
        val root = createTree(test.first)
        println("Result ==> ${countPairs(root, test.second)}")
    }

}

private var countOfPairs = 0
fun countPairs(root: TreeNode?, distance: Int): Int {
    dfsFindPairs(root, distance)
    return countOfPairs
}

private fun dfsFindPairs(root: TreeNode?, distance: Int): List<Int> {
    if (root == null) return emptyList()
    if (root.left == null && root.right == null) {
        return listOf(1)
    }
    val leftList = dfsFindPairs(root.left, distance)
    val rightList = dfsFindPairs(root.right, distance)
    for (dist1 in leftList) {
        for (dist2 in rightList) {
            if (dist2 + dist1 <= distance) countOfPairs++
        }
    }
    val allList = leftList.plus(rightList).map {
        it + 1
    }
    return allList
}
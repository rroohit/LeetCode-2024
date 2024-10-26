package j_october

import z_data_types.TreeNode
import z_data_types.createTree
import kotlin.math.max

/**
 *  Problem 26. Height of Binary Tree After Subtree Removal Queries
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + q)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            listOf(1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7),
            intArrayOf(4)
        ),
        Pair(
            listOf(5, 8, 9, 2, 1, 3, 7, 4, 6),
            intArrayOf(3, 2, 4, 8)
        )
    )

    testCases.forEach { test ->
        val root = createTree(test.first)
        println("Result ==> ${treeQueries(root, test.second).toList()}")
    }

}


private val maxHeightAfterRemoval = IntArray(100001)
var currentMaxHeight = 0
fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
    traverseLeftToRight(root, 0)
    currentMaxHeight = 0
    traverseRightToLeft(root, 0)

    val queryCount: Int = queries.size
    val queryResults = IntArray(queryCount)
    for (i in 0..<queryCount) {
        queryResults[i] = maxHeightAfterRemoval[queries[i]]
    }
    return queryResults
}

private fun traverseLeftToRight(node: TreeNode?, currentHeight: Int) {
    if (node == null) return
    // Store the maximum height if this node were removed
    maxHeightAfterRemoval[node.`val`] = currentMaxHeight

    currentMaxHeight = max(currentMaxHeight, currentHeight)

    traverseLeftToRight(node.left, currentHeight + 1)
    traverseLeftToRight(node.right, currentHeight + 1)
}

private fun traverseRightToLeft(node: TreeNode?, currentHeight: Int) {
    if (node == null) return
    // Update the maximum height if this node were removed
    maxHeightAfterRemoval[node.`val`] = max(maxHeightAfterRemoval[node.`val`], currentMaxHeight)

    currentMaxHeight = max(currentHeight, currentMaxHeight)

    traverseRightToLeft(node.right, currentHeight + 1)
    traverseRightToLeft(node.left, currentHeight + 1)
}
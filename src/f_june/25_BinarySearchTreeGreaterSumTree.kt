package f_june

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeDFS

/**
 *  Problem 25.  Binary Search Tree to Greater Sum Tree
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
        listOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        bstToGst(root)
        printTreeDFS(root)
    }

}

fun bstToGst(root: TreeNode?): TreeNode? {
    dfsToRight(root, 0)
    return root
}

private fun dfsToRight(root: TreeNode?, curSum: Int): Int {
    if (root == null) return curSum
    val right = dfsToRight(root.right, curSum)
    root.`val` += right
    return dfsToRight(root.left, root.`val`)
}
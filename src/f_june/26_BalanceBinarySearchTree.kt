package f_june

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeInorder

/**
 *  Problem 26. Balance a Binary Search Tree
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
        listOf(1, null, 2, null, 3, null, 4, null, null)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        val newRoot = balanceBST(root)
        printTreeInorder(newRoot)
    }

}

private val arr = mutableListOf<TreeNode>()
fun balanceBST(root: TreeNode?): TreeNode? {
    buildArray(root)
    val newRoot = buildBst(0, arr.size - 1)
    return newRoot
}

private fun buildBst(l: Int, r: Int): TreeNode? {
    if (l > r) return null
    val midInd = (l + r) / 2
    val node = arr[midInd]
    node.left = buildBst(l, midInd - 1)
    node.right = buildBst(midInd + 1, r)
    return node
}

private fun buildArray(root: TreeNode?) {
    if (root == null) return
    buildArray(root.left)
    arr.add(root)
    buildArray(root.right)
}
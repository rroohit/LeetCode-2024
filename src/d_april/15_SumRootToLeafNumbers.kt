package d_april

import data_types.TreeNode
import data_types.createTree

/**
 *  Problem 15. Sum Root to Leaf Numbers
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

    val list = listOf(1, 0)
    val root = createTree(list)

    println("Result ==> ${sumNumbers(root)}")

}

fun sumNumbers(root: TreeNode?): Int {
    return treeTravel(root, 0)
}

private fun treeTravel(root: TreeNode?, prevNum: Int): Int {
    val curr = prevNum * 10 + (root?.`val` ?: 0)

    // base case
    if (root?.left == null && root?.right == null) return curr

    /// visit left node
    val left = if (root.left != null) treeTravel(root.left, curr) else 0

    // visit right node
    val right = if (root.right != null) treeTravel(root.right, curr) else 0

    return left + right
}
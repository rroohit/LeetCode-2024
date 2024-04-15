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

    val list = listOf(4, 9, 0, 5, 1)
    val root = createTree(list)

    println("Result ==> ${sumNumbers(root)}")

}

fun sumNumbers(root: TreeNode?): Int {
    return preorderTraversal(root, 0)
}

private fun preorderTraversal(root: TreeNode?, prevNum: Int): Int {
    val curr = prevNum * 10 + (root?.`val` ?: 0)

    // base case
    if (root?.left == null && root?.right == null) return curr

    /// visit left node
    val left = if (root.left != null) preorderTraversal(root.left, curr) else 0

    // visit right node
    val right = if (root.right != null) preorderTraversal(root.right, curr) else 0

    return left + right
}
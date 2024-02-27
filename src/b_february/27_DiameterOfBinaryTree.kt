package b_february

import data_types.TreeNode
import kotlin.math.max

/**
 *  Problem 27.  Diameter of Binary Tree
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


}

private var dim = 0
fun diameterOfBinaryTree(root: TreeNode?): Int {
    dfs(root)
    return dim
}

private fun dfs(root: TreeNode?): Int {
    // base case
    if (root == null) return 0
    val left = dfs(root.left)
    val right = dfs(root.right)
    dim = max(dim, left + right)
    return max(left, right) + 1
}
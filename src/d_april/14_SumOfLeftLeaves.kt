package d_april

import data_types.TreeNode
import data_types.createTree

/**
 *  Problem 14. Sum of Left Leaves
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - n is no of nodes in tree
 *
 *       - Space complexity: o(n)
 *          -  recursion call stack
 *
 * ## Code -
 */
fun main() {

    val list = listOf(3, 9, 20, null, null, 15, 7)

    val root = createTree(list)

    println("Result ==> ${sumOfLeftLeaves(root)}")

}

// dfs
private var sum = 0
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left != null) {
        // if the visiting left node is already leaf add to ans
        val childNode = root.left
        if (childNode?.left == null && childNode?.right == null) sum += childNode?.`val` ?: 0
        // to go left
        sumOfLeftLeaves(root.left)
    }

    if (root.right != null) {
        // to go right
        sumOfLeftLeaves(root.right)
    }

    return sum
}





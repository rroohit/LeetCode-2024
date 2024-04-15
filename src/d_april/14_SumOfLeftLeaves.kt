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

// DFS
fun sumOfLeftLeaves(root: TreeNode?): Int {
    // base case
    if (root == null) return 0

    // Check if the left child is a leaf node
    val leftSum = if (root.left?.left == null && root.left?.right == null) {
        root.left?.`val` ?: 0
    } else {
        sumOfLeftLeaves(root.left) // Recursively compute sum for left subtree
    }

    // visit right node
    val rightSum = sumOfLeftLeaves(root.right)

    return leftSum + rightSum
}


// dfs
private var sum = 0
fun sumOfLeftLeaves1(root: TreeNode?): Int {
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





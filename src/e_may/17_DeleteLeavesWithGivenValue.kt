package e_may

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeDFS

/**
 *  Problem 17. Delete Leaves With a Given Value
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
        Pair(2, listOf(1, 2, 3, 2, null, 2, 4))
    )

    testCases.forEach {
        val target = it.first
        val root = createTree(it.second)
        val newRoot = removeLeafNodes(root, target)
        println("Result")
        printTreeDFS(newRoot)
    }

}

// TC - O(n) : SC - O(n)
// PostOrder : Left -> Right -> Root
fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) return null
    root.left = removeLeafNodes(root.left, target)
    root.right = removeLeafNodes(root.right, target)
    return if (root.left == null && root.right == null && root.`val` == target) null
    else root
}








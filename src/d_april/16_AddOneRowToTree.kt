package d_april

import data_types.TreeNode
import data_types.createTree
import data_types.printTreeDFS

/**
 *  Problem 16. Add One Row to Tree
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

    val list = listOf(4, 2, 6, 3, 1, 5)
    val root = createTree(list)
    val `val` = 1
    val depth = 2

    print("Before adding node => ")
    printTreeDFS(root)
    println()
    println()

    val newRoot = addOneRow(root, `val`, depth)
    print("After adding node  => ")
    printTreeDFS(newRoot)


}

fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    // base case where depth is 1
    if (depth == 1) {
        val newTree = TreeNode(`val`).apply {
            left = root
        }
        return newTree
    }
    replaceTheNode(root, `val`, depth - 1)
    return root
}

// InOrder traversal
private fun replaceTheNode(curr: TreeNode?, num: Int, depth: Int) {
    if (curr == null) return // base case

    if (depth == 1) { // the next node where we will reach the given depth
        val temp: TreeNode = curr
        curr.left = TreeNode(num).apply { left = temp.left }

        curr.right = TreeNode(num).apply { right = temp.right }

    } else {
        replaceTheNode(curr.left, num, depth - 1)
        replaceTheNode(curr.right, num, depth - 1)
    }
}
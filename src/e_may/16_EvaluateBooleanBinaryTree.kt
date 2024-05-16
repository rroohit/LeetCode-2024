package e_may

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 16. Evaluate Boolean Binary Tree
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - where n is the number of nodes in the tree.
 *
 *       - Space complexity: O(h)
 *          - where h is the height of the tree.
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(2, 1, 3, null, null, 0, 1),
        listOf(0)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        println("Result ==> ${evaluateTree(root)}")
    }

}

// PostOrder : Left -> Right -> Root
fun evaluateTree(root: TreeNode?): Boolean {
    return when(root?.`val`) {
        1, 0 -> {
            root.`val` == 1
        }
        2 -> { // OR
            evaluateTree(root.left) || evaluateTree(root.right)
        }
        else -> { // AND
            evaluateTree(root?.left) && evaluateTree(root?.right)
        }
    }
}
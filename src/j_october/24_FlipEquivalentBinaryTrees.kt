package j_october

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 24. Flip Equivalent Binary Trees.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            listOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8),
            listOf(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7)
        )
    )

    testCases.forEach { test ->
        val root1 = createTree(test.first)
        val root2 = createTree(test.second)
        println("Result ==> ${flipEquiv(root1, root2)}")
    }

}

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) return true
    if (root1 == null || root2 == null) return false

    if (root1.`val` != root2.`val`) return false
    val noSwaps = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
    val swaps = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    return noSwaps || swaps
}
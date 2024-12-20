package l_december

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeInorder

/**
 *  Problem 20. Reverse Odd Levels of Binary Tree.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(logn)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(2, 3, 5, 8, 13, 21, 34)
    )

    testCases.forEach { test ->
        val root = createTree(test)
        val result = reverseOddLevels(root)
        printTreeInorder(result)
    }

}

fun reverseOddLevels(root: TreeNode?): TreeNode? {
    traverseDFS(root?.left, root?.right, 0)
    return root
}

private fun traverseDFS(
    leftChild: TreeNode?,
    rightChild: TreeNode?,
    level: Int
) {
    if (leftChild == null || rightChild == null) return

    //If the current level is odd, swap the values of the children.
    if (level % 2 == 0) {
        val temp = leftChild.`val`
        leftChild.`val` = rightChild.`val`
        rightChild.`val` = temp
    }

    traverseDFS(leftChild.left, rightChild.right, level + 1)
    traverseDFS(leftChild.right, rightChild.left, level + 1)
}
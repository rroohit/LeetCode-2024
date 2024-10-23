package j_october

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeDFS
import java.util.*

/**
 *  Problem 23. Cousins in Binary Tree II
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
        listOf(5, 4, 9, 1, 10, null, 7)
    )

    testCases.forEach { test ->
        val root = createTree(test)
        val result = replaceValueInTree(root)
        printTreeDFS(result)
    }

}

fun replaceValueInTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val levelSums = mutableListOf<Int>()
    val nodeQu: Queue<TreeNode?> = LinkedList()
    nodeQu.offer(root)

    while (nodeQu.isNotEmpty()) {
        val size = nodeQu.size
        var currSum = 0
        for (i in 1..size) {
            val top = nodeQu.poll()!!
            currSum += top.`val`
            if (top.left != null) nodeQu.offer(top.left)
            if (top.right != null) nodeQu.offer(top.right)
        }
        levelSums.add(currSum)
    }
    nodeQu.offer(root)
    var levelInd = 1
    root.`val` = 0

    while (nodeQu.isNotEmpty()) {
        val size = nodeQu.size
        for (i in 1..size) {
            val currNode = nodeQu.poll()!!
            val leftVal = currNode.left?.`val` ?: 0
            val rightVal = currNode.right?.`val` ?: 0
            val sibSum = leftVal + rightVal

            if (currNode.left != null) {
                currNode.left?.`val` = levelSums[levelInd] - sibSum
                nodeQu.offer(currNode.left)
            }

            if (currNode.right != null) {
                currNode.right?.`val` = levelSums[levelInd] - sibSum
                nodeQu.offer(currNode.right)
            }
        }
        levelInd++
    }

    return root
}
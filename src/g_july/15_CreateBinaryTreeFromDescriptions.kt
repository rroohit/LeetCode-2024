package g_july

import z_data_types.TreeNode
import z_data_types.printTreeInorder

/**
 *  Problem 15. Create Binary Tree From Descriptions
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
        arrayOf(
            intArrayOf(20, 15, 1),
            intArrayOf(20, 17, 0),
            intArrayOf(50, 20, 1),
            intArrayOf(50, 80, 0),
            intArrayOf(80, 19, 1)
        )
    )

    testCases.forEach { descriptions ->
        val resultHead = createBinaryTree(descriptions)
        printTreeInorder(resultHead)
    }

}

fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val nodeMap = HashMap<Int, TreeNode>()
    val childSet = HashSet<Int>()
    for ((parent, child, dir) in descriptions) {
        childSet.add(child)
        if (!nodeMap.contains(parent)) {
            nodeMap[parent] = TreeNode(parent)
        }
        if (!nodeMap.contains(child)) {
            nodeMap[child] = TreeNode(child)
        }

        if (dir == 1) {
            nodeMap[parent]?.left = nodeMap[child]
        } else {
            nodeMap[parent]?.right = nodeMap[child]
        }

    }

    for ((parent, _, _) in descriptions) {
        if (!childSet.contains(parent)) return nodeMap[parent]
    }

    return null
}
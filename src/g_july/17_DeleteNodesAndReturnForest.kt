package g_july

import z_data_types.TreeNode
import z_data_types.createTree
import z_data_types.printTreeDFS

/**
 *  Problem 17. Delete Nodes And Return Forest
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
        Pair(
            listOf(1, 2, 3, 4, 5, 6, 7),
            intArrayOf(3, 5)
        )
    )


    testCases.forEach { test ->
        val root = createTree(test.first)
        val result = delNodes(root, test.second)

        result.forEach {
            printTreeDFS(it)
            println()
        }
        println()
    }

}

private lateinit var toDeleteNums: HashSet<Int>
private lateinit var setOfNodes: HashSet<TreeNode>
fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
    if (root == null) return emptyList()
    toDeleteNums = to_delete.toHashSet()
    setOfNodes = HashSet()

    setOfNodes.add(root)
    dfsTravel(root)

    return setOfNodes.toList()
}

private fun dfsTravel(root: TreeNode?): TreeNode? {
    if (root == null) return null
    var res: TreeNode? = root
    if (toDeleteNums.contains(res?.`val`)) {
        res = null
        if (setOfNodes.contains(root)) setOfNodes.remove(root)
        if (root.left != null) setOfNodes.add(root.left!!)
        if (root.right != null) setOfNodes.add(root.right!!)
    }
    root.left = dfsTravel(root.left)
    root.right = dfsTravel(root.right)
    return res
}
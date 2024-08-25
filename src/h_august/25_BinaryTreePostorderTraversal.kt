package h_august

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 25. Binary Tree Postorder Traversal
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
        listOf(1,null,2,3)
    )

     testCases.forEach { list ->
         val root = createTree(list)
         val result = postorderTraversalI(root)
         println("Result ==> $result")
     }

}

private val listNums = mutableListOf<Int>()
private fun postorderTraversalI(root: TreeNode?): List<Int> {
    if (root == null) return listNums
    postorderTraversalI(root.left)
    postorderTraversalI(root.right)
    listNums.add(root.`val`)
    return listNums
}
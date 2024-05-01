package d_april

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 17. Smallest String Starting From Leaf
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - n is no of nodes in tree
 *
 *       - Space complexity: O(n)
 *          - n is recursion stack size for each node
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(0, 1, 2, 3, 4, 3, 4), //"dba"
        listOf(25, 1, 3, 1, 3, 0, 2), // "adz"
        listOf(2, 2, 1, null, 1, 0, null, 0) // "abc"
    )

    testCases.forEach { list ->
        val root = createTree(list)
        println("Result => ${smallestFromLeaf(root)}")
    }

}

private val alpha = ('a'..'z').map { it } // alphabets
private var strAns = ""
fun smallestFromLeaf(root: TreeNode?): String {
    strAns = ""
    if (root == null) return strAns
    travelDfs(root,"")
    return strAns
}

private fun travelDfs(root: TreeNode?, prevStr: String) {
    if (root == null) return

    val newStr = "${alpha[root.`val`]}$prevStr"
    if (root.left == null && root.right == null) {
        if (strAns.isEmpty() || newStr < strAns) strAns = newStr
    }

    root.left?.let { travelDfs(it, newStr) }
    root.right?.let { travelDfs(it, newStr) }
}


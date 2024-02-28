package b_february

import data_types.TreeNode
import java.util.*

/**
 *  Problem 28. Find Bottom Left Tree Value
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {


}


fun findBottomLeftValue(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    var curr: TreeNode? = null

    while (queue.isNotEmpty()) {
        curr = queue.pop()
        if (curr.right != null) queue.offer(curr.right)
        if (curr.left != null) queue.offer(curr.left)
    }

    return curr?.`val`!!
}

// DFS
private var result = 0
private var prevLevel = 0
private fun dfs(root: TreeNode?, level: Int) {
    if (root == null) return
    dfs(root.left, level + 1)
    if (level > prevLevel) {
        result = root.`val`
        prevLevel = level
    }
    dfs(root.right, level + 1)
}


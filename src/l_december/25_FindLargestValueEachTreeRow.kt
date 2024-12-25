package l_december

import z_data_types.TreeNode
import z_data_types.createTree
import java.util.*
import kotlin.math.max

/**
 *  Problem 25. Find Largest Value in Each Tree Row.
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
        listOf(1, 3, 2, 5, 3, null, 9),
        listOf(1, 2, 3),
        listOf(-1, -2, -3)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        println("Result ==> ${largestValues(root)}")
    }

}

// DFS :: TC - O(n) :: SC - O(h) i.e - O(n)
fun largestValues(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    dfsToFindMax(root, result, 0)
    return result
}

private fun dfsToFindMax(root: TreeNode?, result: MutableList<Int>, depth: Int) {
    if (root == null) return

    if (result.size == depth) { // when we reach first node in that level.
        result.add(root.`val`)
    } else {
        result[depth] = max(root.`val`, result[depth])
    }

    if (root.left != null) dfsToFindMax(root.left, result, depth + 1)
    if (root.right != null) dfsToFindMax(root.right, result, depth + 1)
}


//-------------------------------------------------------------------------------------------------------------------
// BFS :: TC - O(n) : SC - O(n)
fun largestValues1(root: TreeNode?): List<Int> {
    if (root == null) return listOf()
    val result = mutableListOf<Int>()
    val qu = LinkedList<TreeNode>()
    qu.offer(root)

    while (qu.isNotEmpty()) {
        var max: Int? = null
        val size = qu.size
        repeat(size) {
            val curr = qu.poll() ?: return@repeat
            if (max == null || max!! < curr.`val`) {
                max = curr.`val`
            }
            if (curr.left != null) qu.offer(curr.left)
            if (curr.right != null) qu.offer(curr.right)
        }
        result.add(max!!)
    }

    return result
}


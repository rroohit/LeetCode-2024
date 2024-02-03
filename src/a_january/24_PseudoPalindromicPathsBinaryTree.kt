package a_january

import data_types.TreeNode
import data_types.createTree

/**
 *  Problem = 24 : Pseudo-Palindromic Paths in a Binary Tree
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val rootList = listOf(2, 1, 1, 1, 3, null, null, null, null, null, 1)
    val root = createTree(rootList)

    val result = pseudoPalindromicPaths(root)

    println("Result ==> $result")

}

fun pseudoPalindromicPaths(root: TreeNode?): Int {
    val count = mutableMapOf<Int, Int>()
    var odd = 0

    fun dfs(curr: TreeNode?): Int {
        if (curr == null) return 0

        count[curr.`val`] = count.getOrDefault(curr.`val`, 0) + 1
        val oddChange = if (count[curr.`val`]!! % 2 == 1) 1 else -1

        odd += oddChange

        val res: Int = if (curr.left == null && curr.right == null) {
            if (odd <= 1) 1 else 0
        } else {
            dfs(curr.left) + dfs(curr.right)
        }

        odd -= oddChange
        count[curr.`val`] = count[curr.`val`]!! - 1
        return res
    }

    return dfs(root)

}
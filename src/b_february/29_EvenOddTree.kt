package b_february

import data_types.TreeNode
import java.util.*

/**
 *  Problem 29. Even Odd Tree
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



}

fun isEvenOddTree(root: TreeNode?): Boolean {
    var isEven = true
    val que = LinkedList<TreeNode>()
    que.offer(root)

    while (que.isNotEmpty()) {
        var prev = if (isEven) Int.MIN_VALUE else Int.MAX_VALUE
        val len = que.size
        for (i in 0..< len) {
            val curr =  que.pop()

            if (isEven && (curr.`val` % 2 == 0 || curr.`val` <= prev)) {
                return false
            } else if (!isEven && ( curr.`val` % 2 == 1 || curr.`val` >= prev)) {
                return false
            }

            if (curr.left != null) que.offer(curr.left)
            if (curr.right != null) que.offer(curr.right)

            prev = curr.`val`
        }

        isEven = !isEven

    }

    return true
}
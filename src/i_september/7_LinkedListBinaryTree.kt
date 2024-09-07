package i_september

import z_data_types.ListNode
import z_data_types.TreeNode

/**
 *  Problem 7. Linked List in Binary Tree
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {


}

fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    if (head == null) return true
    if (root == null) return false

    if (root.`val` == head.`val` && isPath(head, root)) return true

    return isSubPath(head, root.left) || isSubPath(head, root.right)
}

private fun isPath(head: ListNode?, root: TreeNode?): Boolean {
    if (head == null) return true

    if (root?.`val` != head.`val`) return false

    return isPath(head.next, root.left) || isPath(head.next, root.right)
}
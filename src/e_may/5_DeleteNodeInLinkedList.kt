package e_may

import z_data_types.ListNode

/**
 *  Problem 5. Delete Node in a Linked List
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

fun deleteNode(node: ListNode?) {
    if (node?.next != null) {
        node.`val` = node.next!!.`val`
        node.next = node.next?.next
    }
}
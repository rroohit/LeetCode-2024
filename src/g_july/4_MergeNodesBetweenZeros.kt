package g_july

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 4. Merge Nodes in Between Zeros
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

    val testCases = listOf(
        intArrayOf(0, 3, 1, 0, 4, 5, 2, 0)
    )

    testCases.forEach { list ->
        val head = createLinkedList(list)
        val newHead = mergeNodes(head)
        printLinkedList(newHead)
    }

}

fun mergeNodes(head: ListNode?): ListNode? {
    val newHead: ListNode? = head
    var left = newHead
    var right: ListNode? = head?.next

    while (right != null) {
        if (left == null) break
        left.`val` += right.`val`
        if (right.`val` == 0) {
            left.next = right.next
            left = left.next
            right = right.next
        }
        right = right?.next
    }

    return newHead
}
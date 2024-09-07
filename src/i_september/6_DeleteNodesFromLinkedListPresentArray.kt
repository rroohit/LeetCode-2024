package i_september

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 6. Delete Nodes From Linked List Present in Array
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

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3, 4, 5)
        )
    )

    testCases.forEach { test ->
        val head = createLinkedList(test.second)
        val result = modifiedList(test.first, head)
        printLinkedList(result)
    }

}

fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
    val set = nums.toSet()
    val dummy = ListNode(-1)
    dummy?.next = head

    var prev = dummy
    var curr = head
    while (curr != null) {
        val num = curr.`val`
        if (set.contains(num)) {
            prev?.next = curr.next
            curr = prev?.next
        } else {
            prev = curr
            curr = curr?.next
        }
    }

    return dummy?.next
}
package c_march

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 21.  Reverse Linked List
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

    val list1 = intArrayOf(10, 1, 13, 6, 9, 5)

    val head = createLinkedList(list1)

    println("Reversed List: ")
    val mergedHead = reverseList(head)
    printLinkedList(mergedHead)

}

// Using recursion
fun reverseList(head: ListNode?): ListNode? {

    return head
}

// Using swapping methods
// TC - O(n) : SC - O(1)
fun reverseList1(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var cur: ListNode? = head

    while(cur != null ) {
        // hold next value
        val temp = cur.next

        // swap the node directions
        cur.next = prev
        prev = cur

        cur = temp
    }

    return prev
}
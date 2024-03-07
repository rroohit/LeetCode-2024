package c_march

import data_types.ListNode

/**
 *  Problem 7. Middle of the Linked List
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - n is no of nodes in linked list
 *
 *       - Space complexity: O(1)
 *
 *
 * ## Code -
 */
fun main() {



}

fun middleNode(head: ListNode?): ListNode? {
    var slow: ListNode? = head
    var fast: ListNode? = head

    while (fast != null){
        if (fast.next == null) return slow
        if (fast.next?.next == null) return slow?.next
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

fun middleNode2(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var size = 0
    while (curr != null) {
        curr = curr.next
        size++
    }

    curr = head
    repeat(size / 2) {
        curr = curr?.next
    }
    return curr
}
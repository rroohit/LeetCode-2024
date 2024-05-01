package c_march

import z_data_types.ListNode
import z_data_types.createLinkedList
import java.util.*

/**
 *  Problem 22. Palindrome Linked List
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

    val list = intArrayOf(1, 2, 2, 2, 1)
    val head = createLinkedList(list)

    println("Result => ${isPalindrome(head)}")

}

fun isPalindrome(head: ListNode?): Boolean {
    val qu = LinkedList<ListNode>()
    var cur: ListNode? = head

    while (cur != null) {
        qu.offer(cur)
        cur = cur.next
    }

    cur = head
    while (cur != null) {
        val last = qu.removeLast()
        if (last.`val` != cur.`val`) return false
        cur = cur.next
    }

    return true
}





package c_march

import data_types.ListNode
import data_types.createLinkedList
import data_types.printLinkedList
import java.util.*

/**
 *  Problem 23. Reorder List
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val list = intArrayOf(1, 2, 3, 4, 5) // ans 1 -> 5 -> 2 -> 4 -> 3
    val head = createLinkedList(list)

    reorderList(head)
    print("Result :: ")
    printLinkedList(head)

}

fun reorderList(head: ListNode?): Unit {
    // Get Middle
    var slow:ListNode? = head
    var fast: ListNode? = head?.next
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // Reversing
    var second:ListNode? = slow?.next
    var prev: ListNode? = null
    slow?.next = null
    while (second != null) {
        val temp:ListNode? = second.next
        second.next = prev
        prev = second
        second = temp
    }

    // Merging
    var first:ListNode? = head
    second = prev
    while (second != null) {
        val temp1 = first?.next
        val temp2 = second.next
        first?.next = second
        second.next = temp1
        first = temp1
        second = temp2
    }

}


// TC - O(n) : SC - O(1)
fun reorderList2(head: ListNode?): Unit {
    val qu = LinkedList<ListNode>()
    var cur: ListNode? = head
    while (cur != null) {
        qu.offer(cur)
        cur = cur.next
    }

    cur = qu.removeFirst()
    while (cur != null && qu.isNotEmpty()) {
        val last: ListNode? = qu.removeLastOrNull()
        cur.next = last

        cur = qu.removeFirstOrNull()
        last?.next = cur
        if (qu.isEmpty()) {
            cur?.next = null
            break
        }
    }

}

















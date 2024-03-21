package c_march

import data_types.ListNode
import data_types.createLinkedList
import data_types.printLinkedList

/**
 *  Problem 20. Merge In Between Linked Lists
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val list1 = intArrayOf(10, 1, 13, 6, 9, 5)
    val list2 = intArrayOf(1000000, 1000001, 1000002)
    val a = 3
    val b = 4

    val head1 = createLinkedList(list1)
    val head2 = createLinkedList(list2)


    println("Result List: ")
    val mergedHead = mergeInBetween(head1, a,  b, head2)
    printLinkedList(mergedHead)

}

fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
    var first: ListNode? = null
    var last: ListNode? = null

    var curr: ListNode? = list1
    for (i in 0..b) {
        if(i == a - 1) {
            first = curr
        }
        if(i == b) {
            last = curr
            break
        }
        curr = curr?.next
    }

    first?.next = list2
    curr = list2
    while(curr != null) {
        if(curr.next == null) {
            curr.next = last?.next
            break
        }
        curr = curr.next
    }

    return list1

}
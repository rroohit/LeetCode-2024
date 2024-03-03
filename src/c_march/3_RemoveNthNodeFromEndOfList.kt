package c_march

import data_types.ListNode

/**
 *  Problem 3. Remove Nth Node From End of List
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    // head = [1,2,3,4,5], n = 2
    val head = ListNode(1)
    val two = ListNode(2)
    val three = ListNode(3)
    val four = ListNode(4)
    val five = ListNode(5)

    head.next = two
    two.next = three
    three.next = four
    four.next = five
    five.next = null

    val n = 2

    removeNthFromEnd(head, n)

    var curr: ListNode? = head
    while (curr != null) {
        print("${curr.`val`} ")
        curr = curr.next
        if (curr != null) print("--> ")
    }
    println()

}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var right: ListNode? = head
    for (i in 0..<n) {
        if (right == null) break
        right = right.next
    }

    var left: ListNode? = dummy

    while (right != null) {
        left = left?.next
        right = right.next
    }

    left?.next = left?.next?.next

    return dummy.next
}
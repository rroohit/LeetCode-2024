package i_september

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 10. Insert Greatest Common Divisors in Linked List
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

    val testCases = listOf(
        intArrayOf(18, 6, 10, 3)
    )

    testCases.forEach { test ->
        val head = createLinkedList(test)
        val result = insertGreatestCommonDivisors(head)
        printLinkedList(result)
    }

}

// 1 --> 2 --> 3 --> 4
fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    if (head?.next == null) return head // single node

    var curr = head
    while (curr != null) {
        val oldNext = curr.next
        val a = curr.`val`
        val b = oldNext?.`val` ?: break

        val gcd = getGCD(a, b)
        curr.next = ListNode(gcd).apply {
            next = oldNext
        }

        curr = oldNext
    }

    return head
}

private fun getGCD(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        getGCD(b, a % b)
    }
}
package e_may

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 7. Double a Number Represented as a Linked List
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
        intArrayOf(1, 8, 9),
        intArrayOf(9, 9, 9)
    )

    testCases.forEach {
        val head = createLinkedList(it)
        val result = doubleIt(head)
        printLinkedList(result)
    }

}

fun doubleIt(head: ListNode?): ListNode? {

    return head

}














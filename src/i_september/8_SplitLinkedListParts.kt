package i_september

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

/**
 *  Problem 8. Split Linked List in Parts
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3),
            5
        ),
        Pair(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            3
        )
    )

    testCases.forEach { test ->
        val head = createLinkedList(test.first)
        val result = splitListToParts(head, test.second)
        result.forEach { listNode ->
            printLinkedList(listNode)
        }
        println()
    }

}

fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
    var linkedListSize = 0
    var currNode = head
    while (currNode != null) {
        currNode = currNode.next
        linkedListSize++
    }

    val splitSize = linkedListSize / k
    var noOfRemainNodes = linkedListSize % k
    val result = Array<ListNode?>(k) { ListNode(-1) }

    currNode = head
    repeat(k) { i ->
        val dummy = ListNode(-1)
        var tail: ListNode? = dummy
        var currSize = splitSize
        if (noOfRemainNodes > 0) {
            currSize++
            noOfRemainNodes--
        }

        repeat(currSize) {
            tail?.next = currNode?.`val`?.let { it1 -> ListNode(it1) }
            tail = tail?.next
            currNode = currNode?.next
        }

        result[i] = dummy.next

    }

    return result
}
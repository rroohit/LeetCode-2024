package e_may

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList
import java.util.*

/**
 *  6. Remove Nodes From Linked List
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

    val testCases = listOf(
        intArrayOf(5, 2, 13, 3, 8),
        intArrayOf(1, 1, 1, 1)
    )

    testCases.forEach { list ->
        val node = removeNodes(createLinkedList(list))
        printLinkedList(node)
    }


}

fun removeNodes(head: ListNode?): ListNode? {
    val nodes = mutableListOf<ListNode>() // SC - O(n)
    var curr: ListNode? = head
    while (curr != null) { // TC - O(n)
        while (nodes.isNotEmpty() && nodes.last().`val` < curr.`val`) {
            nodes.removeLast()
        }
        nodes.add(curr)
        curr = curr.next
    }

    curr = nodes.removeLast()
    while (nodes.isNotEmpty()) {
        val new = nodes.removeLast()
        new.next = curr
        curr = new
    }

    return curr
}



// TC - O(n) :: SC - O(n)
fun removeNodes1(head: ListNode?): ListNode? {
    val nodes = mutableListOf<ListNode>() // SC - O(n)
    var curr = head
    while (curr != null) { // TC - O(n)
        nodes.add(curr)
        curr = curr.next
    }

    val stack = Stack<ListNode>() // SC - O(n)
    var curMax = nodes.last().`val`
    for (i in nodes.size - 1 downTo 0) { // TC - O(n)
        if (nodes[i].`val` >= curMax) {
            stack.push(nodes[i])
            curMax = nodes[i].`val`
        }
    }

    val dummyNode = ListNode(-1)
    curr = dummyNode
    while (stack.isNotEmpty()) { // TC - O(n)
        curr?.next = stack.pop()
        curr = curr?.next
    }

    return dummyNode.next
}

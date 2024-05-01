package c_march

import z_data_types.ListNode

/**
 *  Problem 6. Linked List Cycle
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *          O(N) - both
 *
 *       - Space complexity:
 *          O(N) - Using Hashmap
 *          O(1) - Using Two pointers
 *
 * ## Code -
 */
fun main() {


}

fun hasCycle(head: ListNode?): Boolean {
    var slow: ListNode? = head
    var fast: ListNode? = head?.next?.next

    while (fast != null) {
        if (slow == fast) return true
        slow = slow?.next
        fast = fast.next?.next
    }

    return false
}

// Using hashMap : TC - (N) , SC - O(N)
fun hasCycle2(head: ListNode?): Boolean {
    val visited = HashMap<ListNode, Int>()
    var curr = head
    while (curr != null) {
        if (visited.containsKey(curr)) return true
        visited[curr] = curr.`val`
        curr = curr.next
    }
    return false
}
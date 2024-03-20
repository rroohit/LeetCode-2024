package data_types

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkedList(nums: IntArray): ListNode? {
    if (nums.isEmpty()) return null

    val head = ListNode(nums[0])
    var current: ListNode? = head
    for (i in 1..<nums.size) {
        current?.next = ListNode(nums[i])
        current = current?.next
    }
    return head
}

fun printLinkedList(head: ListNode?) {
    var current: ListNode? = head
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
        if (current != null) print("-> ")
    }
    println()
}
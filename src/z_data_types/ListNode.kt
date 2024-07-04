package z_data_types

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
    val visited = mutableSetOf<ListNode>()
    var current: ListNode? = head
    while (current != null) {
        if (visited.contains(current)) {
            println("Linked list has cycle")
            break
        }
        visited.add(current)
        print("${current.`val`} ")
        current = current.next
        if (current != null) print("-> ") else print("-> null")
    }
    println()
}
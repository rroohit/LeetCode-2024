package i_september

/**
 *  Problem 29. All O`one Data Structure
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


}

class AllOne() {
    val map = HashMap<String, Node?>()
    var head: Node? = null
    private var tail: Node? = null

    fun inc(key: String) {
        addNode(key, true)
    }

    fun dec(key: String) {
        addNode(key, false)
    }

    fun getMaxKey(): String {
        return tail?.key ?: ""
    }

    fun getMinKey(): String {
        return head?.key ?: ""
    }

    fun addNode(key: String, up: Boolean) {
        if (map[key] != null) {
            if (up) {
                val curNode = map[key]
                var nextNode = curNode?.next
                curNode!!.value = curNode.value!! + 1

                while (nextNode != null && curNode.value!! > nextNode.value!!) {
                    swapNodes(curNode, nextNode)
                    nextNode = curNode.next

                }
                if (nextNode == null)
                    tail = curNode


            } else {

                val curNode = map[key]
                curNode!!.value = curNode.value!! - 1
                var prevNode = curNode.prev

                while (prevNode != null && curNode.value!! < prevNode.value!!) {
                    swapNodes(prevNode, curNode)
                    prevNode = curNode.prev
                }
                if (curNode.value == 0) {
                    head = curNode.next
                    map.remove(key)
                }

            }

        } else {
            if (head == null) {
                head = Node(null, null, 1, key)
                tail = head
                map[key] = head

            } else {
                val node = Node(null, head, 1, key)
                head!!.prev = node
                head = node
                map[key] = node
            }
        }
    }

    private fun swapNodes(first: Node, second: Node) {
        val tempNext = second.next
        val tempPrev = second.prev

        second.prev = first.prev
        second.next = first
        if (first.prev != null) {
            first.prev?.next = second
        } else {
            head = second

        }

        first.next = tempNext
        first.prev = second

        if (tempNext != null) {
            tempNext.prev = first
        } else {
            tail = first
        }

    }

    data class Node(
        var prev: Node? = null,
        var next: Node? = null,
        var value: Int? = null,
        val key: String? = null
    )
}



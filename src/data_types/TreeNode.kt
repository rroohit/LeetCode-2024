package data_types

import java.util.*

// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun createTree(nodes: List<Int?>): TreeNode? {
    if (nodes.isEmpty()) return null

    val root = TreeNode(nodes[0]!!)
    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root)

    var i = 1
    while (i < nodes.size) {
        val current = queue.poll()

        val leftValue = nodes[i++]
        if (leftValue != null) {
            current?.left = TreeNode(leftValue)
            queue.add(current?.left)
        }

        if (i < nodes.size) {
            val rightValue = nodes[i++]
            if (rightValue != null) {
                current?.right = TreeNode(rightValue)
                queue.add(current?.right)
            }
        }
    }

    return root
}
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

fun printTreeBFS(root: TreeNode?) {
    if (root == null) return

    val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
    queue.offer(Pair(root, 0))
    var prevLevel = -1

    while (!queue.isEmpty()) {
        val (node, level) = queue.poll()
        if (level != prevLevel) {
            println()
            prevLevel = level
        }
        print("${node.`val`} ")

        node.left?.let { queue.offer(Pair(it, level + 1)) }
        node.right?.let { queue.offer(Pair(it, level + 1)) }
    }
}

fun printTreeDFS(root: TreeNode?) {
    if (root == null) return

    val stack = Stack<Pair<TreeNode, Int>>()
    stack.push(Pair(root, 0))
    var prevLevel = -1

    while (!stack.isEmpty()) {
        val (node, level) = stack.pop()
        if (level != prevLevel) {
            println()
            prevLevel = level
        }
        print("${node.`val`} ")

        node.right?.let { stack.push(Pair(it, level + 1)) }
        node.left?.let { stack.push(Pair(it, level + 1)) }
    }
}

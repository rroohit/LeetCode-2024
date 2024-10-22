package j_october

import z_data_types.TreeNode
import z_data_types.createTree
import java.util.*


/**
 *  Problem 22. Kth Largest Sum In Binary Tree.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(log^2N + k*logN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(listOf(5, 8, 9, 2, 1, 3, 7, 4, 6), 2)
    )

    testCases.forEach { test ->
        val root = createTree(test.first)
        println("Result ==> ${kthLargestLevelSum(root, test.second)}")
    }

}

fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
    val pq = PriorityQueue<Long>()
    val bfsQueue: Queue<TreeNode?> = LinkedList()
    bfsQueue.add(root)
    while (!bfsQueue.isEmpty()) {
        val size = bfsQueue.size
        var sum: Long = 0
        for (i in 0..<size) {
            val poppedNode = bfsQueue.remove()
            sum += poppedNode!!.`val`
            if (poppedNode.left != null) bfsQueue.add(poppedNode.left)
            if (poppedNode.right != null) bfsQueue.add(poppedNode.right)
        }
        pq.add(sum)
        if (pq.size > k) pq.remove()
    }
    if (pq.size < k) return -1
    return pq.peek()
}

fun kthLargestLevelSum2(root: TreeNode?, k: Int): Long {
    val pq = PriorityQueue(
        Collections.reverseOrder<Long>()
    )
    val bfsQueue: Queue<TreeNode> = LinkedList()
    bfsQueue.offer(root)
    while (bfsQueue.isNotEmpty()) {
        val currLevelSize = bfsQueue.size
        var currSum = 0L
        for (i in 0..<currLevelSize) {
            val top = bfsQueue.poll()
            currSum += top.`val`
            if (top.left != null) bfsQueue.offer(top.left)
            if (top.right != null) bfsQueue.offer(top.right)
        }
        pq.offer(currSum)
    }
    if (pq.size < k) return -1
    repeat(k - 1) {
        pq.poll()
    }
    return pq.peek()!!
}
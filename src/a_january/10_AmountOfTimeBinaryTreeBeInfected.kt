package a_january

import util.TreeNode
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 *  Problem = 10 : Amount of Time for Binary Tree to Be Infected
 *
 *  # Intuition  :
 *
 *
 *  # Approach   :
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (m)
 *
 * # Code =>
 */
fun main() {


}

var maxDist = 0
fun amountOfTime(root: TreeNode?, start: Int): Int {
    traverse(root, start)
    return maxDist
}

private fun traverse(root: TreeNode?, start: Int): Int {
    if (root == null) return 0

    val leftDepth = traverse(root.left, start)
    val rightDepth = traverse(root.right, start)

    var depth = 0

    if (root.`val` == start) {
        maxDist = max(leftDepth, rightDepth)
        depth = -1
    } else if (leftDepth >= 0 && rightDepth >= 0) {
        depth = max(leftDepth, rightDepth) + 1
    } else {
        val dist = abs(leftDepth) + abs(rightDepth)
        maxDist = max(maxDist, dist)
        depth = min(leftDepth, rightDepth) - 1
    }

    return depth
}


// From leet code
class Solution {
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        val map = createGraph(root)

        var time = 0
        val queue = LinkedList<Int>()
        val visited = HashSet<Int>()
        queue.offer(start)
        visited.add(start)

        while(queue.isNotEmpty()) {
            val size = queue.size
            for(i in 0..< size) {
                val current = queue.poll()
                val neighbours = map.getOrDefault(current, listOf())
                for(element in neighbours) {
                    if(visited.add(element)) queue.offer(element)
                }
            }
            time++
        }
        return time - 1
    }

    private fun createGraph(node: TreeNode?): HashMap<Int, List<Int>> {
        val map = HashMap<Int, List<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.offer(node)

        while(queue.isNotEmpty()) {
            val size = queue.size
            for(i in 0..< size) {
                val current = queue.poll()
                if(current.left != null) {
                    map[current.`val`] = map.getOrDefault(current.`val`, listOf()) + current.left!!.`val`
                    map[current.left!!.`val`] = map.getOrDefault(current.left!!.`val`, listOf()) + current.`val`
                    queue.offer(current.left)
                }
                if(current.right != null) {
                    map[current.`val`] = map.getOrDefault(current.`val`, listOf()) + current.right!!.`val`
                    map[current.right!!.`val`] = map.getOrDefault(current.right!!.`val`, listOf()) + current.`val`
                    queue.offer(current.right)
                }
            }
        }

        return map
    }
}
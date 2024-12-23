package l_december

import z_data_types.TreeNode
import z_data_types.createTree
import java.util.*


/**
 *  Problem 23. Minimum Number of Operations to Sort a Binary Tree by Level.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        println("Result ==> ${minimumOperations(root)}")
    }

}

fun minimumOperations(root: TreeNode?): Int {
    if (root == null) return 0
    val qu = LinkedList<TreeNode?>()
    qu.offer(root)
    var operations = 0
    while (qu.isNotEmpty()) {
        val sizeOfLevel = qu.size
        val nums = IntArray(sizeOfLevel)
        repeat(sizeOfLevel) { i ->
            val curr = qu.poll() ?: return@repeat
            nums[i] = curr.`val`
            if (curr.left != null) qu.offer(curr.left)
            if (curr.right != null) qu.offer(curr.right)
        }
        operations += getMinSwaps(nums)
    }

    return operations
}

private fun getMinSwaps(original: IntArray): Int {
    var swaps = 0
    val target = original.clone()
    Arrays.sort(target)

    val pos: MutableMap<Int, Int> = HashMap()
    for (i in original.indices) {
        pos[original[i]] = i
    }

    for (i in original.indices) {
        if (original[i] != target[i]) {
            swaps++
            val curPos = pos[target[i]]!!
            pos[original[i]] = curPos
            original[curPos] = original[i]
        }
    }
    return swaps
}

// not valid
private fun numberOfChanges(nums: IntArray): Int {
    val copy = nums.sorted()
    var invalidInd = 0
    for (i in nums.indices) if (copy[i] != nums[i]) invalidInd++
    return if (invalidInd % 2 == 0) invalidInd / 2 else (invalidInd / 2) + 1
}
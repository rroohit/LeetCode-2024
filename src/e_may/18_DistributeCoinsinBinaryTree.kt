package e_may

import z_data_types.TreeNode
import z_data_types.createTree
import kotlin.math.abs

/**
 *  Problem 18. Distribute Coins in Binary Tree
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
        listOf(3, 0, 0),
        listOf(0, 3, 0)
    )

    testCases.forEach { list ->
        val root = createTree(list)
        println("Result ==> ${distributeCoins(root)}")
    }

}

private var result = 0
fun distributeCoins(root: TreeNode?): Int {
    result = 0
    distribute(root)
    return result
}

private fun distribute(node: TreeNode?): Pair<Int, Int> { // (size, coins)
    if (node == null) return Pair(0, 0)

    val (lSize, lCoins) = distribute(node.left)
    val (rSize, rCoins) = distribute(node.right)

    val size = 1 + lSize + rSize
    val coins = node.`val` + lCoins + rCoins
    result += abs(size - coins)
    return Pair(size, coins)
}












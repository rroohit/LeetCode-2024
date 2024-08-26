package h_august

import z_data_types.Node

/**
 *  Problem 26. N-ary Tree Postorder Traversal
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {



}

fun postorder(root: Node?): List<Int> {
    return helper(root, mutableListOf())
}

fun helper(root: Node?, result: MutableList<Int>): List<Int> {
    if (root == null) return result

    for (child in root!!.children)
        helper(child, result)
    result.add(root!!.`val`)

    return result
}
package a_january

import sun.swing.MenuItemLayoutHelper.max
import util.TreeNode
import kotlin.math.min

/**
 *  Problem = 11 : Maximum Difference Between Node and Ancestor
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
 *      - Space complexity: (n)
 *
 * # Code =>
 */

fun main() {



}

fun maxAncestorDiff(root: TreeNode?): Int {
    if (root == null) return 0
    return getMaxDiff(root, root.`val`, root.`val`)
}

private fun getMaxDiff(root: TreeNode?, max: Int, min: Int):  Int {
    if (root == null) return max - min

    val maxVal = max(max, root.`val`)
    val minVal = min(min, root.`val`)

    val leftDiff = getMaxDiff(root.left, maxVal, minVal)
    val rightDiff = getMaxDiff(root.right, maxVal, minVal)

    return max(leftDiff, rightDiff)
}
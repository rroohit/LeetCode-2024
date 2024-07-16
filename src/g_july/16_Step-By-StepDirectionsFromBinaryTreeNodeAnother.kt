package g_july

import z_data_types.TreeNode
import z_data_types.createTree

/**
 *  Problem 16.  Step-By-Step Directions From a Binary Tree Node to Another
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
        Triple(
            listOf(5, 1, 2, 3, null, 6, 4),
            3, 6
        )
    )

    testCases.forEach { test ->
        val root = createTree(test.first)
        println("Result ==> ${getDirections(root, test.second, test.third)}")
    }

}

fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
    fun down(n: TreeNode?, v: Int, sb: StringBuilder = StringBuilder()): String = n?.run {
        if (`val` == v) sb.toString() else {
            sb.append('L');
            val l = down(left, v, sb)
            if (l != "") l else {
                sb.deleteAt(sb.lastIndex); sb.append('R')
                down(right, v, sb).also { sb.deleteAt(sb.lastIndex) }
            }
        }
    } ?: ""

    val s = down(root, startValue);
    val d = down(root, destValue)
    val skip = s.commonPrefixWith(d).length
    return "U".repeat(s.length - skip) + d.drop(skip)
}
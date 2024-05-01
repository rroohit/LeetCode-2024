package b_february

import z_data_types.TreeNode
import java.util.*

/**
 *  Problem 26. Same Tree
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *          - n is total number of nodes in tree
 *
 *       - Space complexity: O(n)
 *          - This is because the recursive calls consume memory on the call stack, and in the worst case scenario,
 *              the call stack can grow as deep as the height of the deeper tree.
 *
 * ## Code -
 */
fun main() {



}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    return (p?.`val` == q?.`val`) &&
            isSameTree(p?.left, q?.left) &&
            isSameTree(p?.right, q?.right)
}

fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
    // base case
    if (p == null && q == null) return true
    if (p == null || q == null) return false // Combine null checks
    val left = isSameTree(p.left, q.left)
    val right = isSameTree(p.right, q.right)
    return (p.`val` == q.`val`) && left && right
}

fun isSameTree3(p: TreeNode?, q: TreeNode?): Boolean {
    val stack = LinkedList<Pair<TreeNode?, TreeNode?>>()
    stack.push(Pair(p, q))

    while (stack.isNotEmpty()) {
        val (nodeP, nodeQ) = stack.pop()

        if (nodeP == null && nodeQ == null) continue
        if (nodeP == null || nodeQ == null || nodeP.`val` != nodeQ.`val`) return false

        stack.push(Pair(nodeP.right, nodeQ.right))
        stack.push(Pair(nodeP.left, nodeQ.left))
    }

    return true
}

// Morris Traversal
fun isSameTree4(p: TreeNode?, q: TreeNode?): Boolean {
    var pCurr = p
    var qCurr = q

    while (pCurr != null || qCurr != null) {
        if (pCurr == null || qCurr == null || pCurr.`val` != qCurr.`val`) {
            return false
        }

        // Morris Traversal to traverse left
        if (pCurr.left != null && qCurr.left != null) {
            val pPred = findPredecessor(pCurr)
            val qPred = findPredecessor(qCurr)
            if (pPred.right == null && qPred.right == null) {
                pPred.right = pCurr
                qPred.right = qCurr
                pCurr = pCurr.left
                qCurr = qCurr.left
            } else {
                if (pPred.right != null || qPred.right != null) {
                    if (pPred.right != pCurr || qPred.right != qCurr) {
                        return false
                    }
                    pPred.right = null
                    qPred.right = null
                }
                pCurr = pCurr.right
                qCurr = qCurr.right
            }
        } else if (pCurr.left != qCurr.left) {
            return false
        } else {
            pCurr = pCurr.right
            qCurr = qCurr.right
        }
    }

    return true
}

fun findPredecessor(node: TreeNode): TreeNode {
    var pred = node.left
    while (pred?.right != null && pred.right != node) {
        pred = pred.right
    }
    return pred!!
}
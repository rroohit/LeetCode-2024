package g_july

import z_data_types.ListNode
import z_data_types.createLinkedList
import kotlin.math.min

/**
 *  Problem 5. Find the Minimum and Maximum Number of Nodes Between Critical Points
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(5, 3, 1, 2, 5, 1, 2),
        intArrayOf(3, 1)
    )

    testCases.forEach { nums ->
        val head = createLinkedList(nums)
        val result = nodesBetweenCriticalPoints(head)
        println("Result ==> ${result.toList()}")
    }

}

fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
    var leftInd = -1
    var minDiff = Int.MAX_VALUE

    var prevIndex = 1
    var curIndex = 2
    var prevNum = head?.`val`
    var currNode = head?.next

    while (currNode != null) {
        val nextNum = currNode.next?.`val` ?: break
        val midNum = currNode.`val`

        if ((midNum > prevNum!! && midNum > nextNum) ||
            (midNum < prevNum && midNum < nextNum)
        ) {
            if (leftInd == -1) {
                leftInd = curIndex
            } else {
                minDiff = min(minDiff, curIndex - prevIndex)
            }
            prevIndex = curIndex
        }
        curIndex++
        prevNum = midNum
        currNode = currNode.next

    }

    return if (minDiff == Int.MAX_VALUE) intArrayOf(-1, -1) else intArrayOf(minDiff, prevIndex - leftInd)
}

















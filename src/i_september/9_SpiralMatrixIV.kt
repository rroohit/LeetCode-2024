package i_september

import z_data_types.ListNode
import z_data_types.createLinkedList

/**
 *  Problem 9. Spiral Matrix IV
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(max(linkedListSize, (m * n))
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            3, 5,
            intArrayOf(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)
        )
    )

    testCases.forEach { test ->
        val head = createLinkedList(test.third)
        val result = spiralMatrix(test.first, test.second, head)
        println("Result ==> ")
        result.forEach {
            println(it.toList())
        }
        println()
    }

}

// 1  2  3 - T
// 4  5  6   |
// 7  8  9 - B
fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
    val matrix = Array(m) { IntArray(n) { -1 } }

    var currNode = head
    var left = 0
    var right = n - 1
    var top = 0
    var bottom = m - 1

    while (currNode != null) {
        // left --> right
        for (col in left..right) {
            if (currNode == null) break
            matrix[top][col] = currNode.`val`
            currNode = currNode.next
        }
        top++

        // top --> bottom
        for (row in top..bottom) {
            if (currNode == null) break
            matrix[row][right] = currNode.`val`
            currNode = currNode.next
        }
        right--

        // right --> left
        for (col in right downTo left) {
            if (currNode == null) break
            matrix[bottom][col] = currNode.`val`
            currNode = currNode.next
        }
        bottom--

        // bottom --> up
        for (row in bottom downTo top) {
            if (currNode == null) break
            matrix[row][left] = currNode.`val`
            currNode = currNode.next
        }
        left++
    }

    return matrix
}

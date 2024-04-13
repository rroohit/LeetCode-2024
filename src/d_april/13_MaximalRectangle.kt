package d_april

import kotlin.math.max

/**
 *  Problem 13. Maximal Rectangle
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: o(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val matrix = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')
    )

    println("Result ==> ${maximalRectangle(matrix)}")

}

fun maximalRectangle(matrix: Array<CharArray>): Int {
    // Histogram
    val histogram = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }

    // For first row of
    for (c in matrix[0].indices) {
        histogram[0][c] = matrix[0][c].digitToInt()
    }

    for (r in 1..<matrix.size) { // row
        for (c in 0..<matrix[0].size) { // column
            val curr = matrix[r][c].digitToInt()
            if (curr == 0) continue
            val prev = histogram[r - 1][c]
            histogram[r][c] = prev + curr
        }
    }
    printMatrix(histogram)

    var area = 0
    histogram.forEach {
        area = max(area, maxRectOfHistogram(it))
    }

    return area
}

private fun maxRectOfHistogram(heights: IntArray): Int {
    // Create a stack to store indices of histogram bars
    val stack = mutableListOf<Int>()

    var maxArea = 0
    var i = 0
    while (i < heights.size) {
        // If the stack is empty or the current bar's height is greater than or
        // equal to the height of the bar at the top of the stack
        if (stack.isEmpty() || heights[i] >= heights[stack.last()]) {
            stack.add(i)// Add the index of the current bar to the stack
            i++
        } else {
            // If the current bar's height is less than the height of the bar at the top of the stack
            // Remove the top index from the stack and calculate the area of the rectangle with the removed bar as the height
            val topIndex = stack.removeAt(stack.size - 1)
            val height = heights[topIndex]

            // Calculate the width of the rectangle by subtracting the index of the current bar from the index of the bar at the top of the stack
            val width = if (stack.isEmpty()) i else i - stack.last() - 1
            maxArea = maxOf(maxArea, height * width)
        }
    }

    // Process the remaining bars in the stack to calculate the area of the rectangles they form
    while (stack.isNotEmpty()) {
        val topIndex = stack.removeAt(stack.size - 1)
        val height = heights[topIndex]

        val width = if (stack.isEmpty()) i else i - stack.last() - 1
        maxArea = maxOf(maxArea, height * width)
    }
    return maxArea
}


private fun printMatrix(histogram: Array<IntArray>) {
    histogram.forEach {
        println(it.toList())
    }
}



























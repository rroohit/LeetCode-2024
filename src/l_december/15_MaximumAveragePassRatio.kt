package l_december

import java.util.*


/**
 *  Problem 15. Maximum Average Pass Ratio.
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
        Pair(
            arrayOf(
                intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2)
            ), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxAverageRatio(test.first, test.second)}")
    }


}

fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
    var mExtraStudents = extraStudents
    val maxHeap = PriorityQueue { a: DoubleArray, b: DoubleArray ->
        b[0].compareTo(a[0])
    }

    for (singleClass in classes) {
        val passes = singleClass[0]
        val totalStudents = singleClass[1]
        val gain = calculateGain(passes, totalStudents)
        maxHeap.offer(doubleArrayOf(gain, passes.toDouble(), totalStudents.toDouble()))
    }

    while (mExtraStudents-- > 0) {
        val current = maxHeap.poll()
        val passes = current[1].toInt()
        val totalStudents = current[2].toInt()
        maxHeap.offer(
            doubleArrayOf(
                calculateGain(passes + 1, totalStudents + 1),
                (passes + 1).toDouble(),
                (totalStudents + 1).toDouble(),
            )
        )
    }

    var totalPassRatio = 0.0
    while (!maxHeap.isEmpty()) {
        val current = maxHeap.poll()
        val passes = current[1].toInt()
        val totalStudents = current[2].toInt()
        totalPassRatio += passes.toDouble() / totalStudents
    }

    return totalPassRatio / classes.size
}

private fun calculateGain(passes: Int, totalStudents: Int): Double {
    return ((passes + 1).toDouble() / (totalStudents + 1) - passes.toDouble() / totalStudents)
}
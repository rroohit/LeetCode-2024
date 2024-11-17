package k_november


/**
 *  Problem 17. Shortest Subarray with Sum at Least K.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(intArrayOf(1), 1),
        Pair(intArrayOf(1, 2), 4),
        Pair(intArrayOf(2, -1, 2), 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${shortestSubarray(test.first, test.second)}")
    }

}

fun shortestSubarray(nums: IntArray, k: Int): Int {
    val n: Int = nums.size

    val cumulativeSumStack: MutableList<Pair<Long, Int>> = ArrayList()
    cumulativeSumStack.add(Pair(0L, -1))

    var runningCumulativeSum: Long = 0
    var shortestSubarrayLength = Int.MAX_VALUE

    for (i in 0..<n) {
        runningCumulativeSum += nums[i]

        while (cumulativeSumStack.isNotEmpty() &&
            runningCumulativeSum <=
            cumulativeSumStack[cumulativeSumStack.size - 1].first
        ) {
            cumulativeSumStack.removeAt(cumulativeSumStack.size - 1)
        }

        cumulativeSumStack.add(Pair(runningCumulativeSum, i))

        val candidateIndex = findCandidateIndex(
            cumulativeSumStack,
            runningCumulativeSum - k
        )

        if (candidateIndex != -1) {
            shortestSubarrayLength = Math.min(
                shortestSubarrayLength,
                i - cumulativeSumStack[candidateIndex].second
            )
        }
    }

    return if (shortestSubarrayLength == Int.MAX_VALUE) -1 else shortestSubarrayLength
}

private fun findCandidateIndex(
    nums: List<Pair<Long, Int>>,
    target: Long
): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid].first <= target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return right
}
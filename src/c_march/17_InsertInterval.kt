package c_march

/**
 *  Problem 17. Insert Interval
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

    val intervals = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16)
    )

    val newInterval = intArrayOf(4, 8)

    val result = insert(intervals, newInterval)

    result.forEach {
        print("${it.toList()} ")
    }

}


fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val ans = mutableListOf<IntArray>()

    for (i in intervals.indices) {
        if (newInterval[1] < intervals[i][0]) {
            ans.add(newInterval)
            return ans.toTypedArray() + intervals.copyOfRange(i, intervals.size)
        } else if (newInterval[0] > intervals[i][1]) {
            ans.add(intervals[i])
        } else {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
        }
    }

    ans.add(newInterval)
    return ans.toTypedArray()
}























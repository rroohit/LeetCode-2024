package f_june

/**
 *  Problem 18. Most Profit Assigning Work
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
        ProfitAssignment(
            intArrayOf(2, 4, 6, 8, 10),
            intArrayOf(10, 20, 30, 40, 50),
            intArrayOf(4, 5, 6, 7)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxProfitAssignment(test.difficulty, test.profit, test.worker)}")
    }

}

data class Job(val difficulty: Int, val profit: Int)

fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
    worker.sortDescending()
    val jobs = mutableListOf<Job>()
    for (i in difficulty.indices) {
        jobs.add(Job(difficulty[i], profit[i]))
    }

    jobs.sortWith { x, y ->
        y.profit.compareTo(x.profit)
    }

    var w = 0
    var j = 0
    var sum = 0
    while (w < worker.size && j < jobs.size) {
        if (jobs[j].difficulty <= worker[w]) {
            sum += jobs[j].profit
            w += 1
        } else {
            j += 1
        }
    }

    return sum
}

data class ProfitAssignment(
    val difficulty: IntArray,
    val profit: IntArray,
    val worker: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProfitAssignment

        if (!difficulty.contentEquals(other.difficulty)) return false
        if (!profit.contentEquals(other.profit)) return false
        if (!worker.contentEquals(other.worker)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = difficulty.contentHashCode()
        result = 31 * result + profit.contentHashCode()
        result = 31 * result + worker.contentHashCode()
        return result
    }
}
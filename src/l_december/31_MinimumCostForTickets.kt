package l_december


/**
 *  Problem 31. Minimum Cost For Tickets.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(k)
 *
 *       - Space complexity: O(k)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 4, 6, 7, 8, 20),
            intArrayOf(2, 7, 15)
        ),
        Pair(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),
            intArrayOf(2, 7, 15)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${mincostTickets(test.first, test.second)}")
    }


}

private lateinit var needToTravel: BooleanArray
private lateinit var dp: IntArray
private var lastDay = -1

fun mincostTickets(days: IntArray, costs: IntArray): Int {
    needToTravel = BooleanArray(366) { false }
    dp = IntArray(366) { -1 }
    lastDay = days[days.size - 1]
    for (day in days) needToTravel[day] = true
    return getMinCost(1, costs)
}

private fun getMinCost(currDay: Int, costs: IntArray): Int {
    if (currDay > lastDay) return 0
    if (!needToTravel[currDay]) return getMinCost(currDay + 1, costs)

    if (dp[currDay] != -1) return dp[currDay]

    dp[currDay] = minOf(
        costs[0] + getMinCost(currDay + 1, costs),
        costs[1] + getMinCost(currDay + 7, costs),
        costs[2] + getMinCost(currDay + 30, costs)
    )

    return dp[currDay]
}


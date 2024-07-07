package g_july

/**
 *  Problem 7. Water Bottles
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(Log(Numbottles))
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(9, 3),
        Pair(15, 4),
        Pair(15, 8),
        Pair(4, 2)
    )

    testCases.forEach { test  ->
        println("Result ==> ${numWaterBottles(test.first, test.second)}")
        println()
    }

}

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var count = 0
    var availBottles = numBottles
    var carryEmpty = 0

    while (availBottles > 0) {
        // drink
        count += availBottles
        // exchange
        val temp = availBottles + carryEmpty
        availBottles = (temp / numExchange)
        carryEmpty = temp % numExchange
    }

    return count
}
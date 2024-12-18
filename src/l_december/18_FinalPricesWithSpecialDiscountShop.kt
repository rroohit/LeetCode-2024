package l_december

import java.util.*

/**
 *  Problem 18. Final Prices With a Special Discount in a Shop.
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

    val testCases = listOf(
        intArrayOf(8, 4, 6, 2, 3),
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(10, 1, 1, 6),
        intArrayOf(4, 7, 1, 9, 4, 8, 8, 9, 4)// 3,6,1,5,0,0,4,5,4
    )

    testCases.forEach { prices ->
        println("Result ==> ${finalPrices(prices).toList()}")
    }

}

fun finalPrices(prices: IntArray): IntArray {
    val stack = Stack<Int>()

    for (i in prices.indices) {
        while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
            prices[stack.pop()] -= prices[i];
        }
        stack.push(i)
    }

    return prices
}

// TC - O(n²) :: SC - O(n)
fun finalPrices1(prices: IntArray): IntArray {
    for (i in prices.indices) {
        var j = i + 1
        while (j < prices.size) {
            if (prices[j] <= prices[i]) break
            j++
        }
        if (j >= prices.size) continue
        prices[i] = prices[i] - prices[j]
    }
    return prices
}
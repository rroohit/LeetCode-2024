package f_june

import kotlin.math.max

/**
 *  Problem 21. Grumpy Bookstore Owner
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

    val customers = intArrayOf(1, 0, 1, 2, 1, 1, 7, 5)
    val grumpy = intArrayOf(0, 1, 0, 1, 0, 1, 0, 1)
    val minutes = 3

    println("Result ==> ${maxSatisfied(customers, grumpy, minutes)}")

}

fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var noOfSatisfiedCust = 0
    for (i in customers.indices) {
        // Those customers who get satisfied for sure
        if (grumpy[i] == 0) {
            noOfSatisfiedCust += customers[i]
            customers[i] = 0
        }
    }

    // get max window of customers
    var maxCount = 0
    var currCount = 0
    var l = 0
    for (r in customers.indices) {
        currCount += customers[r]
        if (r - l + 1 > minutes) {
            currCount -= customers[l++]
        }
        maxCount = max(maxCount, currCount)
    }

    return noOfSatisfiedCust + maxCount
}
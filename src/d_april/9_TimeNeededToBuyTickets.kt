package d_april

import kotlin.math.min

/**
 *  Problem 9. Time Needed to Buy Tickets
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(100) =  O(1)
 *          - 100 max size of array
 *
 *       - Space complexity: o(1)
 *
 * ## Code -
 */
fun main() {

    val tickets = intArrayOf(84, 49, 5, 24, 70, 77, 87, 8)
    val k = 3 // ans = 154

    println("Result ==> ${timeRequiredToBuy(tickets, k)}")

}

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var time = 0
    val ticketReq = tickets[k]

    for (i in tickets.indices) {
        time += min(ticketReq, tickets[i])
        if (i > k && tickets[i] > ticketReq) time--
    }

    return time
}


// TC (100 + 100) == O(1) :: SC - O(1)
fun timeRequiredToBuy1(tickets: IntArray, k: Int): Int {
    var ans = 0

    repeat(tickets[k]) {
        for (i in tickets.indices) {
            if (tickets[i] > 0) {
                tickets[i] = tickets[i] - 1
                ans++
                if (tickets[k] == 0) return ans
            }
        }
    }

    return ans
}
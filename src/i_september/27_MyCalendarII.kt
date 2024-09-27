package i_september

/**
 *  Problem 27. My Calendar II
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(10, 20),
        Pair(50, 60),
        Pair(10, 40),
        Pair(5, 15),
        Pair(5, 10),
        Pair(25, 55)
    )

    val myCalendarTwo = MyCalendarTwo()

    testCases.forEach { test ->
        println("Result ==> ${myCalendarTwo.book(test.first, test.second)}")
    }

}

class MyCalendarTwo() {
    private val booking = arrayListOf<Pair<Int, Int>>()
    private val doubleBooking = arrayListOf<Pair<Int, Int>>()
    fun book(start: Int, end: Int): Boolean {
        doubleBooking.forEach {
            if (isOverLap(it, Pair(start, end)))
                return false
        }
        booking.forEach {
            if (isOverLap(it, Pair(start, end)))
                doubleBooking.add(Pair(Math.max(it.first, start), Math.min(it.second, end)))
        }
        booking.add(Pair(start, end))

        return true
    }

    private fun isOverLap(booking: Pair<Int, Int>, currBooking: Pair<Int, Int>): Boolean {
        return booking.first.coerceAtLeast(currBooking.first) < Math.min(booking.second, currBooking.second)
    }

}
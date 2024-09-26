package i_september

/**
 *  Problem 26. My Calendar I
 *
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(10, 20),
        Pair(15, 25),
        Pair(20, 30)
    )

    val myCalendar = MyCalendar()

    testCases.forEach { test ->
        println("Result ==> ${myCalendar.book(test.first, test.second)}")
    }


}

class MyCalendar() {
    private val listOfEvents = ArrayList<Pair<Int, Int>>()
    fun book(start: Int, end: Int): Boolean {
        for (prevEvent in listOfEvents) {
            if (prevEvent.first < end && start < prevEvent.second) return false
        }
        listOfEvents.add(Pair(start, end))
        return true
    }
}



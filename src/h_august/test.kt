package h_august

import java.util.*

fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(8, 8, 8, 8),
            4
        ),
        Pair(
            arrayOf(1, 4, 5, 6),
            4
        ),
        Pair(
            arrayOf(1, 2, 4),
            4
        ),
        Pair(
            arrayOf(10, 10, 8, 9, 1),
            6
        )
    )

    testCases.forEach { test ->
        //println("Result ==> ${getMaximumAmount(test.first, test.second)}")
    }

    val test = listOf(
        Pair(
            arrayOf(1, 1, 1),
            arrayOf(5, 5, 5)
        ),
        Pair(
            arrayOf(2, 3, 7, 4, 7),
            arrayOf(4, 5, 8, 7, 10)
        )
    )

    test.forEach { c ->
        println("Result ==> ${findEarliestMaxTrafficTime(c.first, c.second)}")
    }

}


fun findEarliestMaxTrafficTime(start: Array<Int>, end: Array<Int>): Int {
    val events = mutableListOf<Pair<Int, Int>>()

    // Create start and end events
    for (i in start.indices) {
        events.add(Pair(start[i], 1)) // 1 for start of interaction
        events.add(Pair(end[i], -1)) // -1 for end of interaction
    }

    // Sort events; if times are equal, process end events first
    events.sortWith(compareBy({ it.first }, { it.second }))

    println(events)

    var maxTraffic = 0
    var currentTraffic = 0
    var earliestMaxTime = 0

    // Sweep through the events
    for ((time, event) in events) {
        currentTraffic += event
        if (currentTraffic > maxTraffic) {
            maxTraffic = currentTraffic
            earliestMaxTime = time
        }
    }

    return earliestMaxTime
}


fun getMaximumAmount(quantity: Array<Int>, m: Int): Long {
    var amount = 0L
    val priceHeap = PriorityQueue { a: Int, b: Int -> b - a }
    quantity.forEach { price -> priceHeap.add(price) }

    repeat(m) {
        val price = priceHeap.remove()
        amount += price
        priceHeap.add(price - 1)
    }
    return amount
}



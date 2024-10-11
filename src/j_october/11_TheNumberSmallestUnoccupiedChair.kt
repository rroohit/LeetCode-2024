package j_october

import java.util.*

/**
 *  Problem 11. The Number of the Smallest Unoccupied Chair
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
        Pair(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(4, 6)
            ), 1
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${smallestChair(test.first, test.second)}")
    }

}

fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
    val indexedTimes = times.withIndex()
    val arrivalToFriend = indexedTimes.associate { it.value[0] to it.index }
    val leavingToFriends = indexedTimes.groupBy ({ it.value[1] }, { it.index })
    val friendToSeat = mutableMapOf<Int, Int>()

    var capacity = 0
    val availableSeats = PriorityQueue<Int>()

    for (i in 0 .. times[targetFriend][0]) {
        leavingToFriends[i]?.let { friends ->
            for (friend in friends) {
                availableSeats.add(friendToSeat.remove(friend)!!)
            }
        }
        arrivalToFriend[i]?.let {
            if (availableSeats.isEmpty()) {
                friendToSeat[it] = capacity++
            } else {
                friendToSeat[it] = availableSeats.remove()
            }
        }
    }

    return friendToSeat[targetFriend]!!
}
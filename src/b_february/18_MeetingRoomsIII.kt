package b_february

import java.util.*

fun main() {

    val n = 2
    val meetings = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(1, 5),
        intArrayOf(2, 7),
        intArrayOf(3, 4)
    )

    println("Result ==> ${mostBooked(n, meetings)}")

}

/// not working
fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    val busy = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    val avail = PriorityQueue<Int>()

    val count = IntArray(n)

    meetings.sortBy { it[0] }

    for (meeting in meetings) {
        val start = meeting[0]
        val end = meeting[1]

        while (busy.isNotEmpty() && busy.peek().first <= start) {
            val (_, room) = busy.poll()
            avail.offer(room)
        }

        val room = avail.poll()
        if (avail.isNotEmpty()) {
            busy.offer(Pair(end, room))
        } else {
            if (busy.isEmpty()) continue
            val (time, _room) = busy.poll()
            busy.offer(Pair(time + end - start, _room))
        }

        count[room]++
    }

    return count.indexOf(count.max())
}
package b_february

import java.util.*

/**
 *  Problem 23. Cheapest Flights Within K Stops
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(|V| + |E|)
 *
 *       - Space complexity: O(|V|)
 *
 * ## Code -
 */
fun main() {
    // [[],[],[],[]]
    val n = 4
    val flights = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(2, 0, 100),
        intArrayOf(1, 3, 600),
        intArrayOf(2, 3, 200),
    )
    val flights1 = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(0, 2, 5),
        intArrayOf(1, 2, 1),
        intArrayOf(2, 3, 1),
    )

    val src = 0
    val dst = 3
    val k = 1

    val result = findCheapestPrice(n, flights, src, dst, k)

    println("Result ==> $result")

}

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    for (flight in flights) {
        graph.getOrPut(flight[0]) { mutableListOf() }.add(flight[1] to flight[2])
    }

    val memo = mutableMapOf<Pair<Int, Int>, Int>() // Memoization for (node, stops) -> minCost

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.offer(Triple(src, 0, 0)) // (node, cost, stops)

    var minCost = Int.MAX_VALUE

    while (queue.isNotEmpty()) {
        val (node, cost, stops) = queue.poll()
        val key = node to stops

        if (memo.containsKey(key) && memo[key]!! < cost) continue // If we've found a cheaper path before

        if (node == dst) {
            minCost = minOf(minCost, cost)
            continue
        }

        if (stops > k) continue // We've exceeded the maximum stops

        for ((nextNode, price) in graph[node] ?: emptyList()) {
            if (cost + price >= minCost) continue // Pruning for efficiency

            val nextKey = nextNode to (stops + 1)
            val nextCost = cost + price

            if (!memo.containsKey(nextKey) || nextCost < memo[nextKey]!!) {
                memo[nextKey] = nextCost
                queue.offer(Triple(nextNode, nextCost, stops + 1))
            }
        }
    }

    return if (minCost == Int.MAX_VALUE) -1 else minCost
}


fun findCheapestPrice1(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    // map : from -> to
    val mapFromTo = HashMap<Int, MutableList<Int>>()
    // map : (from, to) -> price
    val mapPrice = HashMap<Pair<Int, Int>, Int>()

    flights.forEach { flt ->
        mapFromTo.getOrPut(flt[0]) { mutableListOf() }.add(flt[1])
        mapPrice[Pair(flt[0], flt[1])] = flt[2]
    }

    println(mapFromTo)
    println(mapPrice)

    val toVisit = IntArray(n) { Int.MAX_VALUE }
    val visited = mutableListOf<Int>()
    val queue = LinkedList<Int>()
    queue.offer(src)
    toVisit[src] = 0

    println(toVisit.toList())

    var kk = k

    while (kk >= 0 && queue.isNotEmpty()) {
        val from = queue.poll()
        val fromPrice = toVisit[from]
        visited.add(from)
        val size = mapFromTo[from] ?: continue

        println("$from -> $size")

        for (to in size) {
            if (visited.contains(to)) continue
            println("($from,$to)  -> ${mapPrice[Pair(from, to)]}")
            val prev = toVisit[to]
            val curr = mapPrice[Pair(from, to)] ?: continue

            if (curr + fromPrice < prev) toVisit[to] = curr + fromPrice

            queue.offer(to)
        }
        kk--
    }
    println(queue)
    println(toVisit.toList())


    return if (toVisit[dst] == Int.MAX_VALUE) -1 else toVisit[dst]
}
// 6
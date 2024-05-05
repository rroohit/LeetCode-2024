package e_may

/**
 *  Problem 4. Boats to Save People
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
        Pair(3, intArrayOf(1, 2)),
        Pair(3, intArrayOf(3, 2, 2, 1)),
        Pair(5, intArrayOf(3, 5, 3, 4))
    )

    testCases.forEach { test ->
        val people = test.second
        val limit = test.first
        println("Result ==> ${numRescueBoats(people, limit)}")
    }

}

fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort() // TC - O(log n) : SC - O(n)
    var boats = 0
    var l = 0
    var r = people.size - 1

    while (l <= r) { // TC - O(n)
        val sec = limit - people[r] // second person weight
        r--
        if (l <= r && sec >= people[l]) l++
        boats++
    }

    return boats
}
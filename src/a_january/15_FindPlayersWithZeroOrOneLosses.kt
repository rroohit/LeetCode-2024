package a_january

/**
 *  Problem = 15 : Find Players With Zero or One Losses
 *
 *  # Intuition  :
 *
 *
 *  # Approach   :
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n + m)
 *
 *      - Space complexity: (n)
 *
 * # Code =>
 */
fun main() {

    // matches[i] = [winneri, loseri]
    // [[1,2,10],[4,5,7,8]]

    val matches = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 6),
        intArrayOf(5, 6),
        intArrayOf(5, 7),
        intArrayOf(4, 5),
        intArrayOf(4, 8),
        intArrayOf(4, 9),
        intArrayOf(10, 4),
        intArrayOf(10, 9)
    )

    val result = findWinners(matches)

    println("Result ==> $result")

}

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    // map -> loser, count
    val mapWin = mutableMapOf<Int, Int>()

    matches.forEach {
        mapWin[it[1]] = mapWin.getOrDefault(it[1], 0) + 1
    }

    val win = mutableListOf<Int>()
    val lose = mutableListOf<Int>()

    matches.forEach {
        if (!mapWin.contains( it[0] ) && !win.contains( it[0] )) {
            win.add( it[0] )
        }

        if (mapWin[it[1]] == 1 && !win.contains(it[1])) {
            lose.add(it[1])
        }
    }

    return listOf(win.sorted(), lose.sorted())
}
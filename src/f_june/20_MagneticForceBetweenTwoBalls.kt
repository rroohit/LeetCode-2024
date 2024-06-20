package f_june

/**
 *  Problem 20. Magnetic Force Between Two Balls
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: (n log n)
 *          - The sorting step takes O(n log n)
 *          - The binary search loop runs O(log d) times.
 *          - Each call to canPlaceAllBalls within the binary search takes O(n) time.
 *
 *        *** Thus the overall time complexity is:
 *          -  O(nlogn + nlogd)
 *          -  Since logd is independent of n,
 *          -  This can be simplified to: O(nlogn + nlogd)
 *          -  In most cases nlogn will dominate,
 *           So we can approximate the time complexity as: O(nlogn)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 2, 3, 4, 7),
            3
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maxDistance(test.first, test.second)}")
    }

}

fun maxDistance(position: IntArray, m: Int): Int {
    position.sort()
    var force = -1
    var l = 0
    var r = position.last()

    while (l <= r) {
        val dist = (l + r) / 2
        if (canPlaceAllBalls(position, dist, m)) {
            // try lower dist
            force = dist
            l = dist + 1
        } else {
            // try increasing dist
            r = dist - 1
        }
    }

    return force
}

private fun canPlaceAllBalls(position: IntArray, dist: Int, ballsReqToPlace: Int): Boolean {
    var noOfBallsPlaced = 1
    var lastBallPos = position.first()
    for (i in 1..< position.size) {
        if (position[i] - lastBallPos >= dist) {
            noOfBallsPlaced++
            lastBallPos = position[i]
        }
    }
    return noOfBallsPlaced >= ballsReqToPlace
}
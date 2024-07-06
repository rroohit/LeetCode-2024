package g_july

/**
 *  Problem 6. Pass the Pillow
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(s)
 *          - s is given seconds time
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(4, 5),
        Pair(4, 6),
        Pair(3, 2)
    )

    testCases.forEach { test ->
        println("Result ==> ${passThePillow(test.first, test.second)}")
    }

}

fun passThePillow(n: Int, time: Int): Int {
    var remTime = time
    var direction = 0 // 0 -> :: 1 <-
    var currInd = 1

    while (remTime > 0) {
        if (direction == 0) {
            currInd++
            if (currInd == n) direction = 1
        } else {
            currInd--
            if (currInd == 1) direction = 0
        }
        remTime--
    }

    return currInd
}
package i_september

/**
 *  Problem 11. Minimum Bit Flips to Convert Number
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(7, 10)
    )

    testCases.forEach { test ->
        println("Result ==> ${minBitFlips(test.first, test.second)}")
    }

}

fun minBitFlips(start: Int, goal: Int): Int {
    var xorVal = start xor goal
    var flips = 0
    while (xorVal > 0) {
        flips += if (xorVal and 1 == 1) 1 else 0
        xorVal = xorVal shr 1
    }
    return flips
}
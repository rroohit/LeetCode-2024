package e_may

/**
 *  Problem 31. Single Number III
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
        intArrayOf(1, 2, 1, 3, 2, 5),
        intArrayOf(-1, 0),
        intArrayOf(0, 1)
    )

    testCases.forEach { nums ->
        println("Result ==> ${singleNumber(nums).toList()}")
    }

}

fun singleNumber(nums: IntArray): IntArray {
    var xorAll = 0
    for (num in nums) {
        xorAll = xorAll xor num
    }

    val setBit = xorAll and -xorAll
    var a = 0
    var b = 0

    for (num in nums) {
        if (num and setBit != 0) {
            a = a xor num
        } else {
            b = b xor num
        }
    }

    return intArrayOf(a, b)
}
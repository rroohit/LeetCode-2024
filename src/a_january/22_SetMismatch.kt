package a_january

/**
 *  Problem = 22 : Set Mismatch
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (n)
 *
 * # Code =>
 */
fun main() {

    val nums = intArrayOf(3, 2, 3, 4, 6, 5)

    val result = findErrorNums(nums)

    println("Result ==> ${result.toList()}")

}

fun findErrorNums(nums: IntArray): IntArray {
    val n = nums.size
    val map = IntArray(n + 1) { 0 }

    for (i in nums) {
        map[i] += 1
    }

    var du = -1 // duplicate
    var mis = -1 // missing

    map.forEachIndexed { index, i ->
        if (i == 0) mis = index
        if (i == 2) du = index
        if (du != -1 && mis != -1) return@forEachIndexed
    }

    return intArrayOf(du, mis)
}
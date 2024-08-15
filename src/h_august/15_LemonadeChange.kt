package h_august

/**
 *  Problem 15. Lemonade Change
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(5, 5, 5, 10, 20),
        intArrayOf(5, 5, 10, 10, 20)
    )

    testCases.forEach { bills ->
        println("Result ==> ${lemonadeChange(bills)}")
    }

}

fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0
    var tweenty = 0

    for (bill in bills) {
        when (bill) {
            5 -> five++
            10 -> {
                // given back five
                if (five <= 0) return false
                five--
                ten++
            }

            20 -> {
                tweenty++
                if (ten > 0 && five > 0) {
                    ten--
                    five--
                } else if (five > 2) {
                    five -= 3
                } else {
                    return false
                }
            }
        }
    }
    return true
}
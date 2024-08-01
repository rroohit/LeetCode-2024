package h_august

/**
 *  Problem 1. Number of Senior Citizens
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
        arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010"),
        arrayOf(
            "9751302862F0693",
            "3888560693F7262",
            "5485983835F0649",
            "2580974299F6042",
            "9976672161M6561",
            "0234451011F8013",
            "4294552179O6482"
        )
    )

    testCases.forEach { details ->
        println("Result ==> ${countSeniors(details)}")
    }

}

fun countSeniors(details: Array<String>): Int {
    var count = 0
    for (detail in details) {
        val a = detail[11]
        val b = detail[12]
        if (a > '6') {
            count++
        } else if (a == '6' && b > '0') {
            count++
        }
    }
    return count
}

fun countSeniors1(details: Array<String>): Int {
    var count = 0
    for (detail in details) {
        val a = detail[11].digitToInt() * 10
        val b = detail[12].digitToInt()
        if (a + b > 60) count++
    }
    return count
}
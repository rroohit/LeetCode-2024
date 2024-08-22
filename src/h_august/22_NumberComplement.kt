package h_august

/**
 *  Problem 22. Number Complement
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        5,
        1,
        2
    )

    testCases.forEach { num ->
        println("Result ==> ${findComplement(num)}")
    }

}

fun findComplement(num: Int): Int {
    val binNum = num.toString(2)
    val strBuild = StringBuilder()
    binNum.forEach {
        strBuild.append(
            if (it == '1') "0" else "1"
        )
    }
    return strBuild.toString().toInt(2)
}
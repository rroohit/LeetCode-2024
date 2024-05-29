package e_may

/**
 *  Problem 29. Number of Steps to Reduce a Number in Binary Representation to One
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
        "1101",
        "10",
        "1"
    )

    testCases.forEach { s ->
        println("Result Number of Steps ==> ${numSteps(s)}")
    }

}

fun numSteps(s: String): Int {
    var l = s.lastIndex
    var carry = 0
    var steps = 0

    while( l > 0) {
        val num = s[l].digitToInt()
        if( num + carry == 0 ) {
            carry = 0
            steps++

        } else if(num + carry == 2) {
            carry = 1
            steps++
        } else {
            carry = 1
            steps += 2
        }
        l--
    }
    if(carry == 1)  steps++
    return steps
}













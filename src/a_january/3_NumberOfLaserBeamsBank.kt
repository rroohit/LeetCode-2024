package a_january

/**
 *  Problem = 3 : Number of Laser Beams in a Bank
 *
 *  # Intuition  :
 *
 *
 *  # Approach   :
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n + m) -
 *
 *      - Space complexity: (1)
 *
 * # Code =>
 */
fun main() {

    // ans = 8
    val bank = arrayOf(
        "011001",
        "000000",
        "010100",
        "001000",
    )

    val result = numberOfBeams(bank)

    println("Result ==> $result")

}

fun numberOfBeams(bank: Array<String>): Int {
    var prev = bank[0].count { it == '1' }
    var res = 0

    for (i in 1 ..< bank.size) {
        val curr = bank[i].count { it == '1' }
        if (curr > 0) {
            res += (prev * curr)
            prev = curr
        }
    }

    return res
}
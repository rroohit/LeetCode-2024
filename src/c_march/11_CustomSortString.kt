package c_march

/**
 *  Problem 11. Custom Sort String
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

    // ans -  "bcad"
    val order = "bcafg"
    val s = "abcd"

    val result = customSortString(order, s)

    println("Result ==> $result")

}

fun customSortString(order: String, s: String): String {
    val counter = HashMap<Char, Int>()

    for (c in s) {
        counter[c] = counter.getOrDefault(c, 0) + 1
    }

    val sb = StringBuilder()

    for (o in order) {
        for (i in 0..<counter.getOrDefault(o, 0)) {
            sb.append(o)
        }
        counter[o] = 0
    }

    for ((key, value) in counter) {
        for (i in 0..<value) {
            sb.append(key)
        }
    }

    return sb.toString()
}
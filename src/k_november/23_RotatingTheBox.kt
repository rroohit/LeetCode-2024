package k_november

/**
 *  Problem 23. Rotating the Box.
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
        arrayOf(charArrayOf('#', '.', '#')),
        arrayOf(
            charArrayOf('#', '#', '*', '.', '*', '.'),
            charArrayOf('#', '#', '#', '*', '.', '.'),
            charArrayOf('#', '#', '#', '.', '#', '.')
        )
    )

    testCases.forEach { box ->
        println("Result ==> ")
        rotateTheBox(box).map {
            println(it.toList())
        }
        println()
    }

}

fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    val m: Int = box.size
    val n: Int = box[0].size
    val result = Array(n) { CharArray(m) { '.' } }

    for (i in 0..<m) {
        var lowestRowWithEmptyCell = n - 1
        for (j in n - 1 downTo 0) {
            if (box[i][j] == '#') {
                result[lowestRowWithEmptyCell][m - i - 1] = '#'
                lowestRowWithEmptyCell--
            }
            if (box[i][j] == '*') {
                result[j][m - i - 1] = '*'
                lowestRowWithEmptyCell = j - 1
            }
        }
    }
    return result
}
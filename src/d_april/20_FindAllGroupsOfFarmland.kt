package d_april

/**
 *  Problem 20. Find All Groups of Farmland
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m * n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 1)
        )
    )

    testCases.forEach { land ->
        val landStartEnd = findFarmland(land)
        landStartEnd.forEach {
            println(it.toList())
        }
    }

}

fun findFarmland(land: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    for (r in land.indices) { // Row
        for (c in land[0].indices) { // Column

            if (land[r][c] == 1) {
                land.forEach { println(it.toList()) }
                land[r][c] = 0
                var h = c + 1 // Horizontal
                while (h < land[0].size && land[r][h] == 1) {
                    land[r][h] = 0
                    h++
                }

                var v = r + 1 // Vertical
                while (v < land.size && land[v][c] == 1) {
                    for (k in c..<h ) {
                        land[v][k] = 0
                    }
                    v++
                }
                result.add(intArrayOf(r, c, v - 1, h - 1))
            }
            println()
        }
    }

    return result.toTypedArray()
}


// 1
fun findFarmland2(land: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    for (r in land.indices) { // Row
        for (c in land[0].indices) { // Column
            if (land[r][c] == 1) {
                // Explore the current farmland and return topLeft and bottomRight
                val starEnd = exploreLand(r, c, land, intArrayOf(r, c, r, c))
                result.add(starEnd)
            }
        }
    }

    return result.toTypedArray()
}

private fun exploreLand(r: Int, c: Int, land: Array<IntArray>, startEnd: IntArray): IntArray {
    if (r < 0 || c < 0 || r >= land.size || c >= land[0].size || land[r][c] != 1) return startEnd
    // update land as visited
    land[r][c] = 0

    if (c >= startEnd[3]) {
        startEnd[2] = r // r2
        startEnd[3] = c // c2
    }

    exploreLand(r, c - 1, land, startEnd) // left
    exploreLand(r, c + 1, land, startEnd) // right
    exploreLand(r - 1, c, land, startEnd) // up
    exploreLand(r + 1, c, land, startEnd) // down

    return startEnd

}










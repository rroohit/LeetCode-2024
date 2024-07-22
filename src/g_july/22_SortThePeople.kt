package g_july

/**
 *  Problem 22. Sort the People
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(NlogN)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf("Mary", "John", "Emma", "Charlie"),
            intArrayOf(180, 165, 170, 190)
        ) // [Mary, Emma, John]
    )

    testCases.forEach { test ->
        println("Result ==> ${sortPeople(test.first, test.second).toList()}")
    }

}

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
    val n = names.size - 1
    var swaped = false
    while (true) {
        swaped = false
        var l = 0
        var r = n
        while (l < n) {
            // from left
            var curr = heights[l]
            val next = heights[l + 1]
            if (next > curr) {
                // swap it
                swapNames(names, l)
                swapHeights(heights, l)
                swaped = true
            }

            // from right
            curr = heights[r]
            val prev = heights[r - 1]
            if (prev < curr) {
                swapNames(names, r - 1)
                swapHeights(heights, r - 1)
            }
            l++
            r--
        }

        if (!swaped) break
    }
    return names
}

private fun swapNames(names: Array<String>, l: Int) {
    val temp = names[l]
    names[l] = names[l + 1]
    names[l + 1] = temp
}

private fun swapHeights(heights: IntArray, l: Int) {
    val temp = heights[l]
    heights[l] = heights[l + 1]
    heights[l + 1] = temp
}

fun sortPeople1(names: Array<String>, heights: IntArray): Array<String> {
    // SC - O(n)
    val mapList = mutableListOf<PeopleData>()
    for (i in names.indices) {
        mapList.add(
            PeopleData(
                name = names[i],
                height = heights[i]
            )
        )
    }

    mapList.sortByDescending { it.height } // TC - O(n logn)
    return mapList.map { it.name }.toTypedArray()
}

private data class PeopleData(
    val name: String,
    val height: Int
)






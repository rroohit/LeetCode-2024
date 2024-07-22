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
            arrayOf("Mary", "John", "Emma"),
            intArrayOf(180, 165, 170)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${sortPeople(test.first, test.second).toList()}")
    }

}

fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
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






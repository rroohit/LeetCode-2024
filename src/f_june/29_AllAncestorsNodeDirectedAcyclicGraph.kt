package f_june

/**
 *  Problem 29. All Ancestors of a Node in a Directed Acyclic Graph
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            8,
            arrayOf(
                intArrayOf(0, 3),
                intArrayOf(0, 4),
                intArrayOf(1, 3),
                intArrayOf(2, 4),
                intArrayOf(2, 7),
                intArrayOf(3, 5),
                intArrayOf(3, 6),
                intArrayOf(3, 7),
                intArrayOf(4, 6)
            )
        )
    )


    testCases.forEach { test ->
        println("Result ==> ${getAncestors(test.first, test.second)}")
    }

}

fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
    val ancList = Array(n) { mutableSetOf<Int>() }
    for ((n1, n2) in edges) {
        ancList[n2].add(n1)
    }

    val result = List(n) { mutableListOf<Int>() }
    for (i in 0..<n) {
        val seenAnc = BooleanArray(n)
        val listOfAnc = mutableSetOf<Int>()
        dfsFindAncestors(
            i,
            seenAnc,
            listOfAnc,
            ancList
        )
        result[i].addAll(listOfAnc.sorted())
    }

    return result
}

private fun dfsFindAncestors(
    currNode: Int,
    seenAnc: BooleanArray,
    listOfAnc: MutableSet<Int>,
    ancList: Array<MutableSet<Int>>
) {
    if (seenAnc[currNode]) return
    seenAnc[currNode] = true
    for (parent in ancList[currNode]) {
        listOfAnc.add(parent)
        dfsFindAncestors(
            parent,
            seenAnc,
            listOfAnc,
            ancList
        )
    }
}
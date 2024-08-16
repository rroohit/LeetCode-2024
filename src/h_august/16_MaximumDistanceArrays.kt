package h_august

import kotlin.math.max
import kotlin.math.min

/**
 *  Problem 16. Maximum Distance in Arrays
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
         listOf(
             listOf(1,2,3),
             listOf(4,5),
             listOf(1,2,3)
         ),
         listOf(
             listOf(1),
             listOf(1),
             listOf(1)
         )
     )

    testCases.forEach { arrays ->
        println("Result ==> ${maxDistance(arrays)}")
    }


}

fun maxDistance(arrays: List<List<Int>>): Int {
    var maxDist = 0
    var curMinNum = arrays[0][0]
    var curMaxNum = arrays[0].last()

    for (i in 1..< arrays.size) {
        maxDist = max(
            maxDist,
            max(
                curMaxNum - arrays[i].first(),
                arrays[i].last() - curMinNum
            )
        )
        curMaxNum = max(curMaxNum, arrays[i].last())
        curMinNum = min(curMinNum, arrays[i].first())
    }

    return maxDist
}
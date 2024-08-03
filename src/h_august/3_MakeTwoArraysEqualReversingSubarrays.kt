package h_august

/**
 *  Problem 3. Make Two Arrays Equal by Reversing Subarrays
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
        Pair(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(2, 4, 1, 3)
        ),
        Pair(
            intArrayOf(1, 2, 2, 3),
            intArrayOf(1, 1, 2, 3)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${canBeEqual(test.first, test.second)}")
    }

}

fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
    val seen = HashMap<Int, Int>()
    for (num in target) {
        seen[num] = seen.getOrDefault(num, 0) + 1
    }

    for (num in arr) {
        if (!seen.containsKey(num) || seen[num]!! <= 0) return false
        seen[num] = seen[num]!! - 1
    }
    return true
}

fun canBeEqual1(target: IntArray, arr: IntArray): Boolean {
    target.sort() // TC - O(NlogN) : SC - O(N)
    arr.sort()    // TC - O(NlogN) : SC - O(N)
    return target.contentEquals(arr)
}
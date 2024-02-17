package b_february

/**
 *  16. Least Number of Unique Integers after K Removals
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(nlogn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val arr = intArrayOf(4, 3, 1, 1, 3, 3, 2)

    val result = findLeastNumOfUniqueInts(arr, 3)

    println("Result ==> $result")

}

fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>() // int -> count
    for (num in arr) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val list = map.filter { it.value <= k }.values.sorted()

    var res = map.size
    var kk = k

    for (count in list) {
        kk -= count
        if (kk >= 0) res-- else break
    }

    return res
}

fun findLeastNumOfUniqueInts2(arr: IntArray, k: Int): Int {
    val map = HashMap<Int, Int>() // int -> count
    for (num in arr) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    var res = map.size
    var kk = k

    for (count in map.values.sorted()) {
        kk -= count
        if (kk >= 0) res-- else break
    }

    return res
}
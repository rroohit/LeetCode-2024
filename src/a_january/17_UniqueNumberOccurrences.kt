package a_january

/**
 *  Problem = 17 : Unique Number of Occurrences
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n)
 *
 *      - Space complexity: (m)
 *
 * # Code =>
 */
fun main() {

    val arr = intArrayOf(1, 2, 2, 1, 1, 3)

    val result = uniqueOccurrences(arr)

    println("Result ==> $result")

}

fun uniqueOccurrences(arr: IntArray): Boolean {
    // map : num -> count
    val map = hashMapOf<Int, Int>()

    arr.forEach {
        val currCount = map.getOrDefault(it, 0)
        map[it] = currCount + 1
    }

    val set = mutableSetOf<Int>()
    map.forEach { set.add(it.value) }

    return set.size == map.size
}
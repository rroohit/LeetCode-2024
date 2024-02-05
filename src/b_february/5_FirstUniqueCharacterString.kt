package b_february

/**
 *  Problem = 3 : First Unique Character in a String
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(n)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    val s = "rohit"

    println("Result ==> ${firstUniqChar(s)}")

}

fun firstUniqChar(s: String): Int {
    val chMap = HashMap<Char, MutableList<Int>>()

    for((i, ch) in s.withIndex()) {
        chMap.getOrPut(ch) {mutableListOf()}.add(i)
    }

    for((i, ch) in s.withIndex()) {
        if(chMap[ch]!!.size == 1) return i
    }

    /** var res = Int.MAX_VALUE
    for((key, list) in chMap ) {
    if(list.size == 1) {
    if(list[0] < res){
    res = list[0]
    if(res == 0) break
    }
    }
    }*/

    return -1
}
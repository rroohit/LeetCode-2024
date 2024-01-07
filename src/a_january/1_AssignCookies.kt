package a_january

/**
 *  Problem = 1 : Assign Cookies
 *
 *  # Intuition  :
 *
 *
 *  # Approach   :
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n + m) -
 *
 *      - Space complexity: (1)
 *
 * # Code =>
 */
fun main() {

    val g = intArrayOf(1, 2, 3)
    val s = intArrayOf(1, 1)

    val result = findContentChildren(g, s)

    println("Result ==> $result")

}

fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()

    var ch = 0 // child pointer
    var co = 0 // cookie pointer

    while (ch < g.size) {

        while (co < s.size && g[ch] > s[co]){
            co++
        }

        if (co == s.size) break
        ch++
        co++

    }

    return ch
}
package b_february

import java.util.*

/**
 *  Problem = 6 : Group Anagrams
 *
 *
 *  # Complexity :
 *
 *      - Time complexity:
 *         - O(n + m)
 *           - n -> length of the given string array
 *           - m -> total length of given strings which is 100 at most
 *
 *         ## O(N) - final time complexity
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    // val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val strs = arrayOf("aaabcde","aedcba")

    val result = groupAnagrams(strs)

    println("Result ==> $result")

}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val mapStrs = mutableMapOf<String, MutableList<String>>()

    strs.forEach { word ->
        val qu = PriorityQueue<Char>()
        word.forEach { ch ->
            qu.offer(ch)
        }

        var key = ""
        while (qu.isNotEmpty()) {
            key += "${qu.poll()}"
        }
        mapStrs.getOrPut(key) { mutableListOf()}.add(word)
    }

    val result = mutableListOf<List<String>>()
    mapStrs.forEach { (_, u) ->
        result.add(u)
    }

    return result

}

fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val mapStrs = mutableMapOf<String, MutableList<String>>()

    strs.forEach {
        val alpha = IntArray(26) {0}
        it.forEach { ch ->
            val count = alpha[ch - 'a']
            alpha[ch - 'a'] = count + 1
        }
        val key = alpha.joinToString(",")
        mapStrs.getOrPut(key) { mutableListOf() }.add(it)

    }

    /*val result = mutableListOf<List<String>>()
    mapStrs.forEach { (t, u) ->
        result.add(u)
    }*/

    return mapStrs.values.toList()

}
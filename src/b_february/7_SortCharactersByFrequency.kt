package b_february

// Sort Characters By Frequency
fun main() {

    val s =  "AAAhabb"

    val result = frequencySort(s)

    println("Result ==> $result")

}

fun frequencySort(s: String): String {
    // map : Char -> Count
    val map = HashMap<Char, Int>()

    for (c in s.toList().sorted()) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    val sortedByValue = map.toList().sortedBy { (_, value) -> value }.toMap()

    var result = ""

    sortedByValue.forEach { (t, u) ->
        result = "$t".repeat(u) + result
    }

    return result
}
package g_july

import kotlin.math.min

/**
 *  Problem 27. Minimum Cost to Convert String I
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        TestData(
            source = "abcd",
            target = "acbe",
            original = charArrayOf('a', 'b', 'c', 'c', 'e', 'd'),
            changed = charArrayOf('b', 'c', 'b', 'e', 'b', 'e'),
            cost = intArrayOf(2, 5, 5, 1, 2, 20)
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${minimumCost(test.source, test.target, test.original, test.changed, test.cost)}")
    }

}

private val Char.index: Int
    get() = code - 'a'.code

val INF = Int.MAX_VALUE / 2
val ABC_SIZE = 26

fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
    val d = Array(ABC_SIZE) { IntArray(ABC_SIZE) { INF } }
    repeat(ABC_SIZE) { d[it][it] = 0 }
    for (i in original.indices) {
        val from = original[i].index
        val to = changed[i].index
        d[from][to] = min(d[from][to], cost[i])
    }

    repeat(ABC_SIZE) { k ->
        repeat(ABC_SIZE) { i ->
            repeat(ABC_SIZE) { j ->
                d[i][j] = min(d[i][j], d[i][k] + d[k][j])
            }
        }
    }

    return (source zip target).sumOf{ (c1, c2) ->
        val from = c1.index
        val to = c2.index
        if (d[from][to] != INF) d[from][to].toLong() else return -1L
    }
}


private data class TestData(
    val source: String,
    val target: String,
    val original: CharArray,
    val changed: CharArray,
    val cost: IntArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData

        if (source != other.source) return false
        if (target != other.target) return false
        if (!original.contentEquals(other.original)) return false
        if (!changed.contentEquals(other.changed)) return false
        if (!cost.contentEquals(other.cost)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = source.hashCode()
        result = 31 * result + target.hashCode()
        result = 31 * result + original.contentHashCode()
        result = 31 * result + changed.contentHashCode()
        result = 31 * result + cost.contentHashCode()
        return result
    }
}
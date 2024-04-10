package d_april

import java.util.*

/**
 *  Problem 10. Reveal Cards In Increasing Order
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n logn)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val deck = intArrayOf(17, 13, 11, 2, 3, 5, 7)

    println("Result ==> ${deckRevealedIncreasing(deck).toList()}")

}

fun deckRevealedIncreasing(deck: IntArray): IntArray {
    deck.sort()
    val res = IntArray(deck.size)
    val q: Queue<Int> = LinkedList()
    for (i in deck.indices) {
        q.add(i)
    }

    for (n in deck) {
        val i = q.remove()
        res[i] = n
        if (!q.isEmpty()) {
            q.add(q.remove())
        }
    }

    return res
}
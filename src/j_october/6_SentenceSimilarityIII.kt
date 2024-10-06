package j_october

/**
 *  Problem 6. Sentence Similarity III
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(M + N)
 *
 *       - Space complexity: O(M + N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("My name is Haley", "My Haley")
    )

    testCases.forEach { (sentence1, sentence2) ->
        println("Result ==> ${areSentencesSimilar(sentence1, sentence2)}")
    }

}

fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
    val deque1 = ArrayDeque(sentence1.split(" "))
    val deque2 = ArrayDeque(sentence2.split(" "))
    while (
        !deque1.isEmpty() &&
        !deque2.isEmpty() &&
        deque1.first() == deque2.first()
    ) {
        deque1.removeFirstOrNull()
        deque2.removeFirstOrNull()
    }
    while (
        !deque1.isEmpty() &&
        !deque2.isEmpty() &&
        deque1.last() == deque2.last()
    ) {
        deque1.removeLastOrNull()
        deque2.removeLastOrNull()
    }
    return deque1.isEmpty() || deque2.isEmpty()
}
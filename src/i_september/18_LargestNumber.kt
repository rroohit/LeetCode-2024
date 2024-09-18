package i_september

/**
 *  Problem 18. Largest Number
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N LogN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(10, 2),
        intArrayOf(3, 30, 34, 5, 9)
    )

    testCases.forEach { nums ->
        println("Result ==> ${largestNumber(nums)}")
    }

}

fun largestNumber(nums: IntArray): String {
    val sorted = nums.sortedWith(Comparator { a, b ->
        val a1 = a.toString();
        val b1 = b.toString();
        (b1 + a1).compareTo(a1 + b1);
    })
    if (sorted[0] == 0) return "0";

    val ans = StringBuilder();
    for (it in sorted) {
        ans.append(it.toString());
    }
    return ans.toString();
}
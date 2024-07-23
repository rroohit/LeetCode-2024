package g_july

/**
 *  Problem 23. Sort Array by Increasing Frequency
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N logN)
 *
 *       - Space complexity: O(N)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(1, 1, 2, 2, 2, 3),
        intArrayOf(2, 3, 1, 3, 2),
        intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)
    )


    testCases.forEach { nums ->
        println("Result ==> ${frequencySort(nums).toList()}")
    }

}

fun frequencySort(nums: IntArray): IntArray {
    val freq = HashMap<Int, Int>()
    nums.forEach { freq[it] = freq.getOrDefault(it, 0) + 1 }

    val customComparator = Comparator<Map.Entry<Int, Int>> { a, b ->
        if (a.value == b.value) {
            // same frequency
            b.key.compareTo(a.key)
        } else {
            a.value.compareTo(b.value)
        }
    }

    val sortedList = freq.entries.sortedWith(customComparator)
    var p = 0
    val result = IntArray(nums.size)
    sortedList.forEach { countNum ->
        repeat(countNum.value) {
            result[p++] = countNum.key
        }
    }
    return result
}
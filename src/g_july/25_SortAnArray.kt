package g_july

/**
 *  Problem 25. Sort an Array
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
        intArrayOf(5, 2, 3, 1),
        intArrayOf(5, 1, 1, 2, 0, 0)
    )

    testCases.forEach { nums ->
        println("Result ==> ${sortArray(nums).toList()}")
    }

}

fun sortArray(nums: IntArray): IntArray {
    if (nums.size <= 1) return nums
    mergeSort(nums, 0, nums.size - 1)
    return nums
}

private fun mergeSort(arr: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = left + (right - left) / 2
        mergeSort(arr, left, mid)
        mergeSort(arr, mid + 1, right)
        merge(arr, left, mid, right)
    }
}

private fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid

    // Create temporary arrays
    val L = IntArray(n1)
    val R = IntArray(n2)

    // Copy data to temp arrays L[] and R[]
    for (i in 0..<n1) L[i] = arr[left + i]
    for (j in 0..<n2) R[j] = arr[mid + 1 + j]

    var i = 0
    var j = 0
    var k = left
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i]
            i++
        } else {
            arr[k] = R[j]
            j++
        }
        k++
    }

    // Copy the remaining elements of L[], if any
    while (i < n1) {
        arr[k] = L[i]
        i++
        k++
    }

    // Copy the remaining elements of R[], if any
    while (j < n2) {
        arr[k] = R[j]
        j++
        k++
    }
}
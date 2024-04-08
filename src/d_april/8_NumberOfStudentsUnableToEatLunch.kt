package d_april

/**
 *  Problem 8. Number of Students Unable to Eat Lunch
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val students = intArrayOf(1, 1, 1, 0, 0, 1)
    val sandwiches = intArrayOf(1, 0, 0, 0, 1, 1)

    println("Result ==> ${countStudents(students, sandwiches)}")

}

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    var ans = students.size
    val mapCount = intArrayOf(0, 0) // circular - 0, square - 1
    students.forEach {
        if (it == 0) {
            mapCount[0] = mapCount[0] + 1
        } else {
            mapCount[1] = mapCount[1] + 1
        }
    }

    for (s in sandwiches) {
        if (s == 0) {
            if (mapCount[0] <= 0) return ans
            mapCount[0] = mapCount[0] - 1
            ans--
        } else {
            if (mapCount[1] <= 0) return ans
            mapCount[1] = mapCount[1] - 1
            ans--
        }
    }

    return ans
}














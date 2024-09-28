package i_september

/**
 *  Problem 28.  Design Circular Deque
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(K)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair("insertLast", 1),
        Pair("insertLast", 2),
        Pair("insertFront", 3),
        Pair("insertFront", 4),
        Pair("getRear", -1),
        Pair("isFull", -1),
        Pair("deleteLast", -1),
        Pair("insertFront", 4),
        Pair("getFront", -1),
    ) // [null, true, true, true, false, 2, true, true, true, 4]

    val myCircularDeque = MyCircularDeque(3)

    testCases.forEach { test ->
        val num = test.second
        when (test.first) {
            "insertLast" -> {
                println(myCircularDeque.insertLast(num))
            }

            "insertFront" -> {
                println(myCircularDeque.insertFront(num))
            }

            "getRear" -> {
                println(myCircularDeque.getRear())
            }

            "getFront" -> {
                println(myCircularDeque.getFront())
            }

            "isFull" -> {
                println(myCircularDeque.isFull())
            }

            "deleteLast" -> {
                println(myCircularDeque.deleteLast())
            }

            else -> Unit
        }
    }

}

class MyCircularDeque(val k: Int) {

    val arr = MutableList(k) { -1 }

    private var frontIndex = -1
    private var rearIndex = -1
    private var currSize = 0

    fun insertFront(value: Int): Boolean {
        if (currSize == k) return false
        if (frontIndex == -1 && rearIndex == -1) {
            frontIndex = 0
            rearIndex = 0
            arr[frontIndex] = value
        } else {
            frontIndex = (frontIndex - 1 + k) % k
            arr[frontIndex] = value
        }
        currSize++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (currSize == k) return false

        if (frontIndex == -1 && rearIndex == -1) {
            frontIndex = 0
            rearIndex = 0
            arr[frontIndex] = value
        } else {
            rearIndex = (rearIndex + 1) % k
            arr[rearIndex] = value
        }
        currSize++
        return true
    }

    fun deleteFront(): Boolean {
        if (currSize == 0) return false
        currSize--
        frontIndex = (frontIndex + 1) % k
        return true
    }

    fun deleteLast(): Boolean {
        if (currSize == 0) return false
        currSize--
        rearIndex = (rearIndex - 1 + k) % k
        return true
    }

    fun getFront(): Int {
        if (currSize == 0) return -1
        return arr[frontIndex]
    }

    fun getRear(): Int {
        if (currSize == 0) return -1
        return arr[rearIndex]
    }

    fun isEmpty(): Boolean {
        return currSize == 0
    }

    fun isFull(): Boolean {
        return currSize == k
    }

}


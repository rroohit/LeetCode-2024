package a_january

/**
 *  Problem = 16 : Insert Delete GetRandom O(1)
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: O(1)
 *
 *      - Space complexity: O(n)
 *
 * # Code =>
 */
fun main() {

    // I/P
    // ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    // [[], [1], [2], [2], [], [1], [2], []]

    // O/P [null, true, false, true, 2, true, false, 2]

    val randomizedSet = RandomizedSet()

    randomizedSet.apply {

        println(insert(1))

        println(remove(2))

        println(insert(2))

        println(getRandom())

        println(remove(1))

        println(insert(2))

        println(getRandom())

    }

}

class RandomizedSet() {
    private val map = mutableMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        return if(map.containsKey(`val`)) {
            false
        } else {
            list.add(`val`)
            map[`val`] = list.lastIndex
            true
        }
    }

    fun remove(`val`: Int): Boolean {
        val index = map[`val`] ?: return false
        if(index != list.lastIndex) {
            list[index] = list.last()
            map[list[index]] = index
        }
        map.remove(`val`)
        list.removeLast()
        return true
    }

    fun getRandom(): Int {
        return list.random()
    }

}

/*class RandomizedSet() {
    private val setNums = mutableListOf<Int>()
    private var pointer = 0
    private var size = 0

    fun insert(`val`: Int): Boolean {
        if (setNums.contains(`val`)) return false
        setNums.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        return setNums.remove(`val`)
    }

    fun getRandom(): Int {
        return setNums.random()
    }

}*/

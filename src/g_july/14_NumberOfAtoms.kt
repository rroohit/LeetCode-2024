package g_july

import java.util.*

/**
 *  Problem 14. Number of Atoms
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        "(H2O2)3",
        "H2O",
        "Mg(OH)2",
        "K4(ON(SO3)2)2"
    )

    testCases.forEach { formula ->
        println("Result ==> ${countOfAtoms(formula)}")
        println()
    }

}

fun countOfAtoms1(formula: String): String {
    val atomList = mutableListOf<String>()
    var l = 0 // left
    while (l < formula.length) { // TC - O(n)
        when (val ch = formula[l]) {
            '(' ,
            ')' -> atomList.add("$ch")
            else -> {
                var currStr = "${formula[l]}"
                while (true) {
                    l++
                    if (l == formula.length) break
                    if (formula[l] == '(' || formula[l] == ')' || formula[l].isUpperCase()) break
                    currStr += formula[l]
                }
                atomList.add(currStr)
                continue
            }
        }
        l++
    }
    println(atomList)
    // map => String -> Count
    val stack = Stack<HashMap<String, Int>>()


    return ""
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
fun countOfAtoms(formula: String): String {
    var i = 0
    fun count(): Int {
        if (i > formula.lastIndex || !formula[i].isDigit()) return 1
        val from = i; while (i < formula.length && formula[i].isDigit()) i++
        return formula.substring(from, i).toInt()
    }
    fun dfs(): Map<String, Int> = TreeMap<String, Int>().apply {
        while (i < formula.length) if (formula[i] == ')') break
        else if (formula[i] == '(') {
            i++; val inBrackets = dfs(); i++
            val count = count()
            for ((name, c) in inBrackets) this[name] = c * count + (this[name] ?: 0)
        } else {
            val from = i++; while (i < formula.length && formula[i].isLowerCase()) i++
            val name = formula.substring(from, i)
            this[name] = count() + (this[name] ?: 0)
        }
    }
    return dfs().entries.joinToString("") { it.run { if (value > 1) "$key$value" else key }}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
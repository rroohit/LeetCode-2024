package j_october

/**
 *  Problem 4. Divide Players Into Teams of Equal Skill
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
        intArrayOf(3, 2, 5, 1, 3, 4),
        intArrayOf(3, 4),
        intArrayOf(1, 1, 2, 3)
    )

    testCases.forEach { test ->
        println("Result ==> ${dividePlayers(test)}")
    }

}

fun dividePlayers(skill: IntArray): Long {
    skill.sort()
    val reqSkills = skill.first() + skill.last()
    var l = 0
    var r = skill.size - 1
    var sumOfChemistry = 0L
    while (l < r) {
        val currSkill = skill[l] + skill[r]
        if (currSkill != reqSkills) return -1
        sumOfChemistry += skill[l++] * skill[r--]
    }
    return sumOfChemistry
}
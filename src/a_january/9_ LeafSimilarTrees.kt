package a_january

import data_types.TreeNode

/**
 *  Problem = 9 : Leaf Similar Tree
 *
 *
 *  # Complexity :
 *
 *      - Time complexity: (n + n)
 *
 *      - Space complexity: (m + m)
 *
 * # Code =>
 */
fun main() {

    val root1 = TreeNode(3) // 0
    val root11 = TreeNode(5)
    val root12 = TreeNode(1)
    val root13 = TreeNode(6)
    val root14 = TreeNode(2)
    val root15 = TreeNode(9)
    val root16 = TreeNode(8)
    val root17 = TreeNode(7)
    val root18 = TreeNode(4)

    root1.left = root11
    root1.right = root12

    root11.left = root13
    root11.right = root14

    root14.left = root17
    root14.right = root18

    root12.left = root15
    root12.right = root16


    val root2 = TreeNode(3)
    val root21 = TreeNode(5)
    val root22 = TreeNode(1)
    val root23 = TreeNode(6)
    val root24 = TreeNode(7)
    val root25 = TreeNode(4)
    val root26 = TreeNode(2)
    val root27 = TreeNode(9)
    val root28 = TreeNode(8)

    root2.left = root21
    root2.right = root22

    root21.left = root23
    root21.right = root24

    root22.left = root25
    root22.right = root26

    root26.left = root27
    root26.right = root28


    val result = leafSimilar(root1, root2)
    println("Result ==> $result")

}


fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val list1 = ArrayList<Int>()
    val list2 = ArrayList<Int>()

    dfs(root1, list1)
    dfs(root2, list2)

    return list1 == list2
}

private fun dfs(root: TreeNode?, array: ArrayList<Int>) {
    if (root == null) return

    if (root.left == null && root.right == null) {
        array.add(root.`val`)
        return
    }

    dfs(root.left, array)
    dfs(root.right, array)
}


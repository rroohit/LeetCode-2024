package j_october


/**
 *  Problem 25. Remove Sub-Folders from the Filesystem
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N * K)
 *
 *       - Space complexity:  O(N * K)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
    )

    testCases.forEach { folder ->
        println("Result ==> ${removeSubfolders(folder)}")
    }

}

fun removeSubfolders(folder: Array<String>): List<String> {
    val folderSet: Set<String> = folder.toSet()
    val result = mutableListOf<String>()

    for (f in folder) {
        var isSubFolder = false
        var prefix = f
        while (prefix.isNotEmpty()) {
            val pos = prefix.lastIndexOf('/')
            if (pos == -1) break
            prefix = prefix.substring(0, pos)
            if (folderSet.contains(prefix)) {
                isSubFolder = true
                break
            }
        }
        if (!isSubFolder) result.add(f)
    }

    return result
}
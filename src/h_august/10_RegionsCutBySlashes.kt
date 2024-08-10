package h_august

/**
 *  Problem 10. Regions Cut By Slashes
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(N^2)
 *
 *       - Space complexity: O(N^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(" /", "/ "),
        arrayOf(" /", "  "),
        arrayOf("/\\", "\\/")
    )

    testCases.forEach { grid ->
        println("Result ==> ${regionsBySlashes(grid)}")
    }

}

fun regionsBySlashes(grid: Array<String>): Int {
    var count = 4*grid.size*grid[0].length
    val parent = IntArray(count){it}
    val degree = IntArray(count){0}
    for(j in 0..grid.lastIndex){
        for(i in 0..grid[0].lastIndex){
            val base = (grid[0].length*j + i)*4
            if(grid[j][i] == '\\'){
                if(union(base,base+3,parent, degree)) count--
                if(union(base+1,base+2,parent, degree)) count--
            }else if(grid[j][i] == '/'){
                if(union(base,base + 1,parent, degree)) count--
                if(union(base + 2,base + 3,parent, degree)) count--
            }else {
                if(union(base,base+1,parent, degree)) count--
                if(union(base+1,base+2,parent, degree)) count--
                if(union(base+2,base+3,parent, degree)) count--
            }
            if(i < grid[0].lastIndex){
                if(union(base+2,base+4,parent, degree)) count--
            }
            if(j < grid.lastIndex){
                if(union(base+3,base + grid[0].length*4 + 1 ,parent, degree)) count--
            }
        }
    }
    return count
}

fun findParent(x: Int, parent: IntArray): Int{
    if(x != parent[x]){
        parent[x] = findParent(parent[x], parent)
    }
    return parent[x]
}

fun union(x: Int, y: Int, parent: IntArray, degree: IntArray): Boolean{
    val parentX = findParent(x, parent)
    val parentY = findParent(y, parent)
    if(parentX == parentY) return false
    if(degree[parentX] > degree[parentY]){
        parent[parentY] = parentX
    }else if(degree[parentX] < degree[parentY]){
        parent[parentX] = parentY
    }else {
        parent[parentX] = parentY
        degree[parentY] += 1
    }
    return true
}
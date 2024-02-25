package b_february

/**
 *  Problem 25. Greatest Common Divisor Traversal
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * α(n) + N * sqrt(max_num))
 *          where n is the length of the input array nums, and N is the number of elements in nums.
 *
 *       - Space complexity:  O(n + N)
 *          where n is the length of the input array nums, and N is the number of elements in nums.
 *
 * ## Code -
 */
fun main() {

    val nums = intArrayOf(4, 3, 12, 8)

    println("Result ==> ${canTraverseAllPairs(nums)}")

}

fun canTraverseAllPairs(nums: IntArray): Boolean {
    val uf = UnionFind(nums.size)
    val factorInd = mutableMapOf<Int, Int>()
    for ((i, n) in nums.withIndex()) {
        var num = n
        var f = 2
        while (f * f <= num) {
            if (num % f == 0) {
                if (f in factorInd) {
                    uf.union(i, factorInd[f]!!)
                } else {
                    factorInd[f] = i
                }
                while (num % f == 0) {
                    num /= f
                }
            }
            f++
        }
        if (num > 1) {
            if (num in factorInd) {
                uf.union(i, factorInd[num]!!)
            } else {
                factorInd[num] = i
            }
        }
    }
    return uf.getCount() == 1
}


class UnionFind(n: Int) {
    private val par = IntArray(n) { it }
    private val size = IntArray(n) { 1 }
    private var count = n

    private fun find(x: Int): Int {
        if (par[x] != x)
            par[x] = find(par[x])
        return par[x]
    }

    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        if (px == py) return
        if (size[px] < size[py]) {
            par[px] = py
            size[py] += size[px]
        } else {
            par[py] = px
            size[px] += size[py]
        }
        count--
    }

    fun getCount(): Int {
        return count
    }
}
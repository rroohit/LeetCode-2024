package h_august

/**
 *  Problem 7. Integer to English Words
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity:
 *
 *       - Space complexity:
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(123, 12345, 1234567)
    val solution = Solution()
    testCases.forEach { num ->
        println("Result ==> ${solution.numberToWords(num)}")
    }

}

class Solution {
    fun numberToWords(num: Int): String {
        builder.setLength(0)
        if (num == 0) return "Zero"
        val triples = triples(num)
        for (i in 3 downTo 0) {
            if (triples[i] != 0) {
                builder.append(tripleCache[triples[i]]).append(suffix[i])
            }
        }
        builder.setLength(builder.length - 1)
        return builder.toString()
    }

    private fun triples(n: Int): IntArray {
        var a = n
        val result = IntArray(4)
        var i = 0
        while (a > 0) {
            result[i++] = a % 1000
            a /= 1000
        }
        return result
    }

    companion object {
        val suffix = arrayOf("", "Thousand ", "Million ", "Billion ")

        private val ones = arrayOf(
            "",
            "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "
        )

        private val twoDigitNumbers = arrayOf(
            "",
            "One ",
            "Two ",
            "Three ",
            "Four ",
            "Five ",
            "Six ",
            "Seven ",
            "Eight ",
            "Nine ",
            "Ten ",
            "Eleven ",
            "Twelve ",
            "Thirteen ",
            "Fourteen ",
            "Fifteen ",
            "Sixteen ",
            "Seventeen ",
            "Eighteen ",
            "Nineteen ",
            "Twenty ",
        )

        private val decades = arrayOf(
            "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety ",
        )

        val builder = java.lang.StringBuilder()

        val tripleCache = Array(1000) {
            builder.setLength(0)
            val hundred = it / 100
            if (hundred != 0) {
                builder.append(ones[hundred]).append("Hundred ")
            }
            val twoDigits = it % 100
            if (twoDigits <= 20) {
                builder.append(twoDigitNumbers[twoDigits])
            } else {
                builder.append(decades[twoDigits / 10]).append(ones[twoDigits % 10])
            }
            builder.toString()
        }
    }
}
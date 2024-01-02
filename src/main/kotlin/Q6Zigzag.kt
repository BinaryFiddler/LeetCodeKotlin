import kotlin.math.ceil

class Q6Zigzag {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }

        val result = StringBuilder()
        val matrix: Array<MutableList<Char>> = Array(numRows) { mutableListOf() }

        var row = 0
        var direction = 1

        for (index in s.indices) {
            if (row == numRows - 1) {
                direction = -1
            }
            if (row == 0) {
                direction = 1
            }

            matrix[row].add(s[index])
            row += direction
        }

        for (r in matrix) {
            for (element in r) {
                result.append(element)
            }
        }

        return result.toString()
    }
}
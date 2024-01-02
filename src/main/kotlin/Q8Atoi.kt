class Q8Atoi {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var result = 0
        val start = findStartIndex(s)
        val sign = readSign(s, start)

        if (sign == 0) {
            return 0
        }

        for (index in start until s.length) {
            if (index == start && (s[index] == '-' || s[index] == '+')) {
                continue
            }

            if (!s[index].isDigit()) {
                break
            }

            if (sign > 0) {
                if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && s[index].digitToInt() > 7)) {
                    return Int.MAX_VALUE
                }
            }

            if (sign < 0) {
                if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && s[index].digitToInt() > 8)) {
                    return Int.MIN_VALUE
                }
            }

            result = result * 10 + sign * s[index].digitToInt()
        }

        return result
    }

    private fun readSign(s: String, start: Int): Int {
        if (start >= s.length) {
            return 0
        }

        if (s[start] == '-') {
            return -1
        }
        if (s[start] == '+' || s[start].isDigit()) {
            return 1
        }

        return 0
    }

    private fun findStartIndex(s: String): Int {
        var index = 0

        while (index < s.length && s[index] == ' ') {
            index++
        }
        return index
    }

}
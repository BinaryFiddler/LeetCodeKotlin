class Q13RomanToInt {
    fun romanToInt(s: String): Int {
        var result = 0
        val map = mapOf(
            'M' to  1000,
            'D' to 500,
            'C' to 100,
            'L' to 50,
            'X' to 10,
            'V' to 5,
            'I' to 1
        )

        for (index in s.indices) {
            val previousValue = if (index > 0) map[s[index - 1]] else 0
            val currentValue = map[s[index]]

            if (currentValue!! > previousValue!!) {
                result = result - previousValue - previousValue + currentValue
            } else {
                result += currentValue
            }
        }

        return result
    }
}
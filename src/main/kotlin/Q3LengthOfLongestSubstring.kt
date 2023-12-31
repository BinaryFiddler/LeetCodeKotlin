class Q3LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var existingChars: HashSet<Char> = HashSet()
        var start = 0
        var max = 0

        for (end in s.indices) {
            val currentChar = s[end]
            while (existingChars.contains(currentChar)) {
                existingChars.remove(s[start++])
            }

            existingChars.add(currentChar)
            max = maxOf(max, end - start + 1)
        }
        return max
    }
}
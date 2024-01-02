class Q5LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var result = ""

        for (mid in s.indices) {
            val oddlongest = getLongestPalindromeFrom(s, mid, mid)
            val evenLongest = getLongestPalindromeFrom(s, mid, mid + 1)
            val longest = if (oddlongest.length > evenLongest.length) oddlongest else evenLongest
            result = if (result.length > longest.length) result else longest
        }

        return result
    }

    private fun getLongestPalindromeFrom(s: String, start: Int, end: Int): String {
        if (end > s.length - 1) {
            return ""
        }

        var result = ""
        var left = start
        var right = end

        while (left >= 0 && right < s.length && s[left] == s[right]) {
            result = s.substring(left, right + 1)
            left--
            right++
        }

        return result
    }
}
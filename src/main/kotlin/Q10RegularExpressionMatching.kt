class Q10RegularExpressionMatching {
    fun isMatchForNoStar(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        return (p[0] == '.' || s[0] == p[0]) && isMatchForNoStar(s.substring(1), p.substring(1))
    }

    fun isMatch(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        // check if the first character matches
        val firstMatch = s.isNotEmpty() && (p[0] == '.' || s[0] == p[0])

        return if (p.length > 1 && p[1] == '*') {
            // either skip the pattern or drop one matching char from the string
            isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
        } else {
            firstMatch && isMatch(s.substring(1), p.substring(1))
        }
    }
}
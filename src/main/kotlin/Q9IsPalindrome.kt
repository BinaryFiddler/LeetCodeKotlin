class Q9IsPalindrome {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        var original = x
        var reverted = 0

        while (original > 0) {
            val lastDigit = original % 10

            if (reverted > Int.MAX_VALUE / 10 || (reverted == Int.MAX_VALUE / 10 && lastDigit > 7)) {
                return false
            }

            reverted = reverted * 10 + lastDigit
            original /= 10
        }

        return reverted == x
    }
}
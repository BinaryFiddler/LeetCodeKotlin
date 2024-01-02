import kotlin.math.abs

class Q7ReverseInteger {
    fun reverse(x: Int): Int {
        var result = 0
        var original = x

        while (original != 0) {
            val lastDigit = original % 10

            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0
            }
            if (result < Int.MIN_VALUE / 10 || (result == Int.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0
            }

            result = result * 10 + lastDigit
            original /= 10
        }

        return result
    }
}
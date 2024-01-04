class Q12IntegerToRoman {
    fun intToRoman(num: Int): String {
        val roman = StringBuilder()
        var original = num

        val thousands = original / 1000
        original -= thousands * 1000
        roman.append("M".repeat(thousands))

        val hundreds = original / 100

        when (hundreds) {
            9 -> {
                roman.append("CM")
            }
            in 5..8 -> {
                roman.append("D").append("C".repeat(hundreds - 5))
            }
            4 -> {
                roman.append("CD")
            }
            else -> {
                roman.append("C".repeat(hundreds))
            }
        }

        original -= hundreds * 100

        val tens = original / 10
        when (tens) {
            9 -> {
                roman.append("XC")
            }
            in 5..8 -> {
                roman.append("L").append("X".repeat(tens - 5))
            }
            4 -> {
                roman.append("XL")
            }
            else -> {
                roman.append("X".repeat(tens))
            }
        }

        original -= tens * 10

        when (val ones = original) {
            9 -> {
                roman.append("IX")
            }
            in 5..8 -> {
                roman.append("V").append("I".repeat(ones - 5))
            }
            4 -> {
                roman.append("IV")
            }
            else -> {
                roman.append("I".repeat(ones))
            }
        }

        return roman.toString()
    }
    //    Symbol       Value
    //    I             1
    //    V             5
    //    X             10
    //    L             50
    //    C             100
    //    D             500
    //    M             1000
}
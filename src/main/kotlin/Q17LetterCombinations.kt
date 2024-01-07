class Q17LetterCombinations {
    private val result = mutableListOf<String>()
    private val mapping = mapOf<Char, List<Char>>(
        '2' to listOf<Char>('a', 'b', 'c'),
        '3' to listOf<Char>('d', 'e', 'f'),
        '4' to listOf<Char>('g', 'h', 'i'),
        '5' to listOf<Char>('j', 'k', 'l'),
        '6' to listOf<Char>('m', 'n', 'o'),
        '7' to listOf<Char>('p', 'q', 'r', 's'),
        '8' to listOf<Char>('t', 'u', 'v'),
        '9' to listOf<Char>('w', 'x', 'y', 'z')
    )
    fun letterCombinations(digits: String): List<String> {
        if (digits.length == 0) {
            return result
        }

        backtrack(StringBuilder(), digits, 0)
        return result
    }

    private fun backtrack(candidate: StringBuilder, digits: String, start: Int) {
        if (candidate.length == digits.length) {
            result.add(candidate.toString())
        }

        for (index in start until digits.length) {
            val possibles = mapping[digits[index]]!!
            for (character in possibles) {
                candidate.append(character)
                backtrack(candidate, digits, index + 1)
                candidate.deleteAt(candidate.length - 1)
            }
        }
    }
}
class Q22GenerateParenthesis {
    val result = mutableSetOf<String>()
    val openBrace = ArrayDeque<Char>()

    fun generateParenthesis(n: Int): List<String> {
        backtrack(n, StringBuilder())
        return result.toList()
    }

    private fun backtrack(n: Int, stringBuilder: StringBuilder) {

        if (stringBuilder.length == n * 2) {
            if (openBrace.isEmpty()) {
                result.add(stringBuilder.toString())
            }
            return
        }

        for (brace in listOf('(', ')')) {
            if (brace == ')') {
                if (openBrace.isNotEmpty() && openBrace.last() == '(') {
                    openBrace.removeLast()

                    stringBuilder.append(brace)
                    backtrack(n, stringBuilder)
                    stringBuilder.deleteAt(stringBuilder.length - 1)
                    openBrace.add('(')
                }
            } else {
                openBrace.add('(')
                stringBuilder.append(brace)
                backtrack(n, stringBuilder)
                stringBuilder.deleteAt(stringBuilder.length - 1)
                openBrace.removeLast()
            }
        }
    }
}
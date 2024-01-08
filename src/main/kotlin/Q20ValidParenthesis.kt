class Q20ValidParenthesis {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in s) {
            if (stack.isEmpty() || char == '{' || char == '[' || char == '(') {
                stack.add(char)
            } else if (char == '}' && stack.get(stack.size - 1) == '{') {
                stack.removeLast()
            } else if (char == ')' && stack.get(stack.size - 1) == '(') {
                stack.removeLast()
            } else if (char == ']' && stack.get(stack.size - 1) == '[') {
                stack.removeLast()
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }
}
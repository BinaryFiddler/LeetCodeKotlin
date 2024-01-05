class Q14LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val result = StringBuilder()
        val candidate = strs[0]

        for (i in candidate.indices) {
            val common = candidate[i]
            for (str in strs) {
                if (i > str.length - 1 || str[i] != common) {
                    return result.toString()
                }
            }
            result.append(common)
        }

        return result.toString()
    }
}
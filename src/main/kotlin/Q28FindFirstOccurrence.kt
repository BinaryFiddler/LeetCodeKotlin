class Q28FindFirstOccurrence {
    fun strStr(haystack: String, needle: String): Int {

        for (index in haystack.indices) {
            if (startHere(haystack, needle, index)) {
                return index
            }
        }

        return -1
    }

    private fun startHere(haystack: String, needle: String, start: Int): Boolean {
        var haystackIndex = start
        for (needleIndex in needle.indices) {
            if (haystackIndex > haystack.length -1 || needle[needleIndex] != haystack[haystackIndex]) {
                return false
            }
            haystackIndex++
        }
        return true
    }
}
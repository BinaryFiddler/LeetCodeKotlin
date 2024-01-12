class Q27RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var start = 0;
        var end = nums.size - 1

        while (start <= end) {
            if (nums[start] == `val`) {
                nums[start] = nums[end--]
            } else {
                start++
            }
        }

        return end + 1
    }
}
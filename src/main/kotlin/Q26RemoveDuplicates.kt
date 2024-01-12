class Q26RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        var slow = 0
        var fast = 1
        var current = nums[slow]

        while (fast < nums.size) {
            if (nums[fast] == current) {
                fast++
            } else {
                current = nums[fast]
                nums[++slow] = nums[fast]
            }
        }
        
        return slow + 1
    }
}
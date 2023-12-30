class Q1TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map: HashMap<Int, Int> = HashMap();

        for (index in nums.indices) {
            map[nums[index]] = index
        }

        for (index in nums.indices) {
            if (map.containsKey(target - nums[index]) && (map[target - nums[index]] != index)) {
                return intArrayOf(index, map[target - nums[index]]!!)
            }
        }
        return intArrayOf(-1, -1)
    }
}
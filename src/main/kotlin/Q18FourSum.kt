class Q18FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        nums.sort()

        for (index in nums.indices) {
            val threeSumResults = threeSum(nums, target.toLong() - nums[index], index + 1)
            for (threeSumResult in threeSumResults) {
                result.add(listOf(nums[index], threeSumResult[0], threeSumResult[1], threeSumResult[2]))
            }
        }

        return result.toList()
    }

    fun threeSum(sortedNums: IntArray, target: Long, start: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        for (index in start until sortedNums.size) {
            val twoSumResults = twoSum(sortedNums, target - sortedNums[index], index + 1)

            for (twoSumResult in twoSumResults) {
                result.add(listOf(sortedNums[index], twoSumResult[0], twoSumResult[1]))
            }
        }

        return result.toList()
    }

    fun twoSum(sortedNums: IntArray, target: Long, start: Int): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        var left = start
        var right = sortedNums.size - 1

        while (left < right) {
            if (target - sortedNums[left] == sortedNums[right].toLong()) {
                result.add(listOf(sortedNums[left], sortedNums[right]))
                left++
            } else if (target - sortedNums[left] < sortedNums[right]) {
                right--
            } else {
                left++
            }
        }

        return result.toList()
    }
}
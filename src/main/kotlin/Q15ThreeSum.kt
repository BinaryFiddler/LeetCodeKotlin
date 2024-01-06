import kotlin.math.abs

class Q15ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = HashSet<List<Int>>()
        nums.sort()

        for (index in 0 .. nums.size - 3) {

            var left = index + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[index] + nums[left] + nums[right]
                if (sum == 0) {
                    result.add(listOf(nums[index], nums[left], nums[right]))
                    left++
                } else if (sum > 0) {
                    right--
                } else {
                    left++
                }
            }
        }

        return result.toList()
    }
}
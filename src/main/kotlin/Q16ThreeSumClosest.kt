import kotlin.math.abs

class Q16ThreeSumClosest {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closest = nums[0] + nums[1] + nums[2]

        for (index in 0 .. nums.size - 3) {

            var left = index + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[index] + nums[left] + nums[right]
                if (abs(sum - target) < abs(closest - target)) {
                    closest = sum
                }

                if (sum > target) {
                    right--
                } else {
                    left++
                }
            }
        }

        return closest
    }

}
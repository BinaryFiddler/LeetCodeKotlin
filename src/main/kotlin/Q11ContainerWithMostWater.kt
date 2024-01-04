import kotlin.math.max
import kotlin.math.min

class Q11ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = max(height[left] * (right - left), maxArea)
                left++
            } else {
                maxArea = max(height[right] * (right - left), maxArea)
                right--
            }
        }

        return maxArea
    }
}
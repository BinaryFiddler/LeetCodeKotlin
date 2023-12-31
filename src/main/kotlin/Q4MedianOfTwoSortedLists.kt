class Q4MedianOfTwoSortedLists {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size1 = nums1.size
        val size2 = nums2.size
        val mid = (size1 + size2) / 2

        return if ((size1 + size2) % 2 == 1) {
            findKthElement(nums1, nums2, mid, 0, nums1.size - 1, 0, nums2.size - 1) * 1.0
        } else {
            (findKthElement(nums1, nums2, mid, 0,nums1.size - 1, 0, nums2.size - 1) + findKthElement(nums1, nums2, mid - 1, 0,nums1.size - 1, 0, nums2.size - 1)) / 2.0
        }
    }

    private fun findKthElement(nums1: IntArray, nums2: IntArray, k: Int, start1: Int, end1: Int, start2: Int, end2: Int): Int {

        if (end1 < start1) {
            return nums2[k - start1]
        }
        if (end2 < start2) {
            return nums1[k - start2]
        }

        val mid1 = (start1 + end1) / 2
        val mid2 = (start2 + end2) / 2

        val val1 = nums1[mid1]
        val val2 = nums2[mid2]

        return if (mid1 + mid2 < k) {
            // remove the smaller half of either nums1 or nums2
            if (val1 < val2) {
                findKthElement(nums1, nums2, k, mid1 + 1, end1, start2, end2)
            } else {
                findKthElement(nums1, nums2, k, start1, end1, mid2 + 1, end2)
            }
        } else {
            // remove the larger half of either nums1 or nums2
            if (val1 < val2) {
                findKthElement(nums1, nums2, k, start1, end1, start2, mid2 - 1)
            } else {
                findKthElement(nums1, nums2, k, start1, mid1 - 1, start2, end2)
            }
        }
    }
}
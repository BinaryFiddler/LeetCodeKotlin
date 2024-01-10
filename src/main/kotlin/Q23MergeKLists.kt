class Q23MergeKLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        if (lists.size == 1) {
            return lists[0]
        }
        if (lists.size == 2) {
            return mergeTwoLists(lists[0], lists[1])
        }

        val mid = lists.size / 2

        val left = mergeKLists(lists.sliceArray(0..mid))
        val right = mergeKLists(lists.sliceArray(mid + 1 until lists.size))

        return mergeTwoLists(left, right)
    }

    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var prev = dummy

        var left = list1
        var right = list2

        while (left != null || right != null) {
            if (left == null) {
                prev.next = right
                prev = right!!
                right = right.next
            } else if (right == null) {
                prev.next = left
                prev = left
                left = left.next
            } else if (left.`val` < right.`val`) {
                prev.next = left
                prev = left
                left = left.next
            } else {
                prev.next = right
                prev = right
                right = right.next
            }
        }

        return dummy.next
    }


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
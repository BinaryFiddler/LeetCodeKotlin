class Q19RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        val dummy = ListNode(0)
        var prev = ListNode(0)
        dummy.next = head
        prev.next = dummy

        var slow = head
        var fast = head

        for (i in 0 until n) {
            fast = fast!!.next
        }

        while (fast != null) {
            prev = slow!!
            slow = slow.next
            fast = fast.next
        }

        prev.next = slow!!.next

        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}


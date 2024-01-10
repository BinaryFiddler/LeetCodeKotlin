class Q24SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = head
        var prev = dummy
        dummy.next = current

        while (current?.next != null) {
            val node2 = current.next
            val node3 = node2!!.next

            prev.next = node2
            node2.next = current
            current.next = node3
            prev = current
            current = node3
        }

        return dummy.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
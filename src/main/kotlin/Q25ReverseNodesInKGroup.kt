class Q25ReverseNodesInKGroup {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        return if (head == null) {
            null
        } else {
            val firstGroup = reverseNextKNodes(null, head, k)
            var currentGroup = firstGroup

            while (currentGroup[1].next != null) {
                val nextGroup = reverseNextKNodes(currentGroup[1], currentGroup[1].next!!, k)
                currentGroup[1].next = nextGroup[0]
                currentGroup = nextGroup
            }

            firstGroup[0]
        }
    }

    fun reverseNextKNodes(prev: ListNode?, head: ListNode, k: Int): Array<ListNode> {

        var current = head
        var before = prev
        var counter = 1

        while (counter < k && current.next != null) {
            val originalNext = current.next
            current.next = before
            before = current
            current = originalNext!!
            counter++
        }

        val remaining = current.next
        current.next = before
        head.next = remaining

        if (counter == k) {
            return arrayOf(current, head)
        }

        var end: ListNode? = null
        while (current.next != null) {
            val originalNext = current.next
            current.next = end
            end = current
            current = originalNext!!
        }
        current.next = end
        return arrayOf(head, current)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}
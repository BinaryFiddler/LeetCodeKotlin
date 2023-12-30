class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2

        var dummy = ListNode(0)
        var current = dummy
        var carry = 0;

        while (list1 != null || list2 != null || carry > 0) {


            val left = list1?.`val` ?: 0
            val right = list2?.`val` ?: 0
            val total = left + right + carry

            val sum: Int = total % 10
            carry = total / 10

            var nextNode = ListNode(sum)
            current.next = nextNode
            current = nextNode

            list1 = list1?.next
            list2 = list2?.next
        }

        return dummy.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


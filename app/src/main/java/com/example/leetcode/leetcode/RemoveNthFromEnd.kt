package com.example.leetcode.leetcode

class RemoveNthFromEnd {
    // [1,2,3,4,5,6,7,8,9,10], n = 3
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        dummy.next = head
        var fastPointer: ListNode? = dummy
        var slowPointer: ListNode? = dummy

        fastPointer = moveFastPointer(fastPointer, n)
        slowPointer = moveBothPointers(fastPointer, slowPointer)

        slowPointer?.next = slowPointer?.next?.next

        return dummy.next
    }

    fun moveFastPointer(fastPointer: ListNode?, n: Int): ListNode? {
        var fast = fastPointer
        repeat(n+1) {   // because start from dummy node
            fast = fast?.next
        }
        return fast
    }

    fun moveBothPointers(fastPointer: ListNode?, slowPointer: ListNode?): ListNode? {
        var fast = fastPointer
        var slow = slowPointer
        while (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
        return slow
    }
}
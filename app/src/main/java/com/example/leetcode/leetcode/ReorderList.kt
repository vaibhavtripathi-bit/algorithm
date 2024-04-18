package com.example.leetcode.leetcode

class ReorderList {
    // 143. Reorder List
    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }

    fun mergeLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        while (second != null) {
            val nextTemp = first?.next
            first?.next = second
            first = second
            second = nextTemp
        }
        return l1
    }

    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // Step 1: Find the middle of the linked list
        val middle = findMiddle(head)

        // Step 2: Reverse the second half of the linked list
        val reversed = reverseList(middle?.next)
        middle?.next = null

        // Step 3: Merge the first half and the reversed second half
        mergeLists(head, reversed)
    }

    fun findMiddle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

}
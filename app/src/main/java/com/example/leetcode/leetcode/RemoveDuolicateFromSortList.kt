package com.example.leetcode.leetcode

class RemoveDuolicateFromSortList {
    // 82 Remove Duplicates from Sorted List II
    fun deleteDuplicates(head: ListNode?): ListNode? {
        // Handle empty list or single-node list
        if (head == null) return null

        val dummy = ListNode(0)
        dummy.next = head
        var current: ListNode? = dummy

        // Iterate through the list
        while (current?.next != null) {
            // If current node's value is the same as the next node's value
            val temp = nextNonDuplicateNode(current.next)
            if (current.next == temp){
                current = current.next
            } else {
                current.next = temp?.next
            }
        }

        return dummy.next
    }

    private fun nextNonDuplicateNode(head: ListNode?): ListNode? {
        var current = head
        while (current?.next != null && current.`val` == current.next?.`val`) {
            // Remove the next node by skipping it
            current = current.next
        }
        return current
    }

    // 83. Remove Duplicates from Sorted List

    fun deleteDuplicates1(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var current = head
        while (current?.next != null) {
            if (current.`val` == current.next?.`val`) {
                current.next = current.next?.next
            } else {
                current = current.next
            }
        }
        return head
    }
}
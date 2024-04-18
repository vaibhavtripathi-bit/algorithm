package com.example.leetcode.leetcode

class RemoveLinkedListElements {
    // 203. Remove Linked List Elements
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head
        var current = dummy

        while (current.next != null) {
            if (current.next!!.`val` == `val`) {
                current.next = current.next!!.next
            } else {
                current = current.next!!
            }
        }
        return dummy.next
    }

    fun removeElements1(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return head
        val dummy = ListNode(0)
        dummy.next = head
        var currentNode = head
        var prevNode: ListNode? = dummy

        while (currentNode != null) {
            if (currentNode.`val` == `val`) {
                prevNode?.next = currentNode.next
            } else {
                prevNode = currentNode
            }
            currentNode = currentNode.next
        }
        return dummy.next
    }
}
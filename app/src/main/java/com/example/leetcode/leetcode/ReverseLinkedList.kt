package com.example.leetcode.leetcode

class ReverseLinkedList {

    // 92 Reverse Linked List II

    private fun findPrevLeft(head: ListNode, left: Int): ListNode {
        var prevLeft: ListNode = head
        repeat(left -1) {
            if (prevLeft.next != null) {
                prevLeft = prevLeft.next!!
            }
        }
        return prevLeft
    }

    private fun reverseSublist(prevLeft: ListNode, left: Int, right: Int): Pair<ListNode?, ListNode?> {
        var current: ListNode? = prevLeft.next
        var prev: ListNode? = null

        repeat(right - left + 1) {
            val next = current?.next
            current?.next = prev
            prev = current
            current = next
        }

        return Pair(prev, current) // (4,5)
    }

    private fun connectSublist(prevLeft: ListNode,
                               reverseListnewHead: ListNode?,
                               remainingList: ListNode?) {
        prevLeft.next?.next = remainingList
        prevLeft.next = reverseListnewHead
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || left == right) return head

        val dummy = ListNode(0, head)
        val prevLeft = findPrevLeft(dummy, left)
        val (reverseListnewHead, remainingList) = reverseSublist(prevLeft, left, right)
        connectSublist(prevLeft, reverseListnewHead, remainingList)

        return dummy.next
    }
}
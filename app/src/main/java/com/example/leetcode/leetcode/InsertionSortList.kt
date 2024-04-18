package com.example.leetcode.leetcode

class InsertionSortList {
    // 147. Insertion Sort List
    fun insertionSortList(head: ListNode?): ListNode? {
        // If the list is empty or contains only one node, it is already sorted
        if (head?.next == null) {
            return head
        }

        var sortedHead: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            val next = current.next
            sortedHead = insertNode(sortedHead, current)
            current = next
        }

        return sortedHead
    }

    private fun insertNode(sortedHead: ListNode?, newNode: ListNode): ListNode {
        if (sortedHead == null || newNode.`val` <= sortedHead.`val`) {
            newNode.next = sortedHead
            return newNode
        }

        var current = sortedHead
        while (current?.next != null && current.next!!.`val` < newNode.`val`) {
            current = current.next
        }

        newNode.next = current?.next
        current?.next = newNode

        return sortedHead
    }
}
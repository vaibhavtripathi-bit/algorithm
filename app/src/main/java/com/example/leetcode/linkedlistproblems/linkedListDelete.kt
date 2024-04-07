package com.example.leetcode.linkedlistproblems

class linkedListDelete {

    // more linked list problem related to deletion
    // delete node at position
    // delete node at position from end
    // delete node with value
    // delete node with value from end
    // delete node with value from start
    // delete node with value from middle
    // delete node with value from end

    fun deleteNode(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        if (head.value == value) return head.next
        var current = head
        while (current?.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                return head
            }
            current = current.next
        }
        return head
    }

    fun deleteNodeAtPosition(head: ListNode?, position: Int): ListNode? {
        if (head == null) return null
        if (position == 0) return head.next
        var current = head
        var index = 0
        while (current?.next != null) {
            if (index == position - 1) {
                current.next = current.next!!.next
                return head
            }
            current = current.next
            index++
        }
        return head
    }

    fun deleteNodeAtPositionFromEnd(head: ListNode?, position: Int): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy
        for (i in 1..position + 1) {
            first = first!!.next
        }
        while (first != null) {
            first = first.next
            second = second!!.next
        }
        second!!.next = second.next!!.next
        return dummy.next
    }

    fun deleteNodeWithValue(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        if (head.value == value) return head.next
        var current = head
        while (current?.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                return head
            }
            current = current.next
        }
        return head
    }

    fun deleteNodeWithValueFromEnd(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        dummy.next = head
        var first: ListNode? = dummy
        var second: ListNode? = dummy
        while (first != null) {
            if (first.value == value) {
                second!!.next = second.next!!.next
                return dummy.next
            }
            first = first.next
            second = second!!.next
        }
        return dummy.next
    }

    fun deleteNodeWithValueFromStart(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        if (head.value == value) return head.next
        var current = head
        while (current?.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                return head
            }
            current = current.next
        }
        return head
    }

    fun deleteNodeWithValueFromMiddle(head: ListNode?, value: Int): ListNode? {
        if (head == null) return null
        var current = head
        while (current?.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                return head
            }
            current = current.next
        }
        return head
    }


}
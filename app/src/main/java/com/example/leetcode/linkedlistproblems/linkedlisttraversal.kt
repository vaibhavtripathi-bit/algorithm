package com.example.leetcode.linkedlistproblems

class TraversalLinkedListProblems {
    fun reverseLinkedList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        return prev
    }

    fun reverseLinkedListRecursive(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val reversedList = reverseLinkedListRecursive(head.next)
        head.next!!.next = head
        head.next = null
        return reversedList
    }

    fun reverseLinkedListRecursive1(head: ListNode, prev: ListNode? = null): ListNode {
        if (head.next == null) {
            head.next = prev
            return head
        }
        val next = head.next ?: return head
        head.next = prev
        return reverseLinkedListRecursive1(next, head)
    }

    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        return slow
    }


}

class ListNode {
    var value: Int = 0
    var next: ListNode? = null

    constructor(value: Int) {
        this.value = value
    }

    constructor(value: Int, next: ListNode?) {
        this.value = value
        this.next = next
    }
}


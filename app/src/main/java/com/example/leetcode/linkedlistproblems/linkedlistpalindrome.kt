package com.example.leetcode.linkedlistproblems

class LinkedListPalindromeProblems {
    // linked list palindrome problems
    // check if linked list is palindrome
    // check if linked list is palindrome using stack
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        slow = reverseLinkedList(slow)
        fast = head
        while (slow != null) {
            if (slow.value != fast!!.value) return false
            slow = slow.next
            fast = fast.next
        }
        return true
    }

    private fun reverseLinkedList(head: ListNode?): ListNode? {
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
}

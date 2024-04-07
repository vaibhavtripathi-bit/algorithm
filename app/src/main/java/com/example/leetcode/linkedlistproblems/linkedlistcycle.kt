package com.example.leetcode.linkedlistproblems

class linkedlistcycle {
    // linked list cycle
    // check if linked list has cycle
    // check if linked list has cycle using hashset
    // check if linked list has cycle using two pointer
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (slow == fast) return true
        }
        return false
    }

    fun hasCycleUsingHashSet(head: ListNode?): Boolean {
        if (head == null) return false
        val set = HashSet<ListNode>()
        var current = head
        while (current != null) {
            if (set.contains(current)) return true
            set.add(current)
            current = current.next
        }
        return false
    }
}
package com.example.leetcode.leetcode

class HasCycle {
    //141. Linked List Cycle

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next!!.next
            if (slow == fast) {
                return true
            }
        }
        return false
    } // Complexity O(n) and space O(1)

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
    }// Complexity O(n) and space O(n)

    //detectCycle where the cycle begins
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        while (fast != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next!!.next
            if (slow == fast) {
                slow = head
                while (slow != fast) {
                    slow = slow?.next
                    fast = fast?.next
                }
                return slow
            }
        }
        return null
    }// Complexity O(n) and space O(1)

    fun detectCycleUsingHashSetWhereCycleBegin(head: ListNode?): ListNode? {
        if (head == null) return null
        val set = HashSet<ListNode>()
        var current = head
        while (current != null) {
            if (set.contains(current)) return current
            set.add(current)
            current = current.next
        }
        return null
    }// Complexity O(n) and space O(n)
}
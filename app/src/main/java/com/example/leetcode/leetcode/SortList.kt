package com.example.leetcode.leetcode

class SortList {
    // 148. Sort List

    fun findMiddle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head?.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var tail = dummyHead
        var list1 = l1
        var list2 = l2

        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                tail.next = list1
                list1 = list1.next
            } else {
                tail.next = list2
                list2 = list2.next
            }
            tail = tail.next!!
        }

        if (list1 != null) {
            tail.next = list1
        } else {
            tail.next = list2
        }

        return dummyHead.next
    }

    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val middle = findMiddle(head)
        val right = sortList(middle?.next)
        middle?.next = null
        val left = sortList(head)

        return mergeTwoLists(left, right)
    }

}
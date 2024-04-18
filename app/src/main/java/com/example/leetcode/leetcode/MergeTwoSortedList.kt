package com.example.leetcode.leetcode

class MergeTwoSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        if (list2 == null) return list1
        if (list1 == null) return list2
        var dummy: ListNode? = ListNode(0)
        val current: ListNode? = dummy

        var node1: ListNode? = list1
        var node2: ListNode? = list2

        while (node1 != null && node2 != null) {
            if (node1.`val` < node2.`val`) {
                dummy?.next = node1
                node1 = node1?.next
            } else {
                dummy?.next = node2
                node2 = node2.next
            }
            dummy = dummy?.next
        }

        if (node1 != null) dummy?.next = node1
        if (node2 != null) dummy?.next = node2


        return current?.next
    }
}
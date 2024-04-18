package com.example.leetcode.leetcode

class MergeKSortedList {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        return mergeLists(lists, 0, lists.size -1)
    }

    private fun mergeLists(lists: Array<ListNode?>, start: Int, end: Int): ListNode? {
        if (start == end) return lists[start]
        val mid = start + (end - start)/2
        val leftList = mergeLists(lists, start, mid)
        val rightList = mergeLists(lists, mid + 1, end)
        return mergeTwoLists(leftList, rightList)
    }

    private fun mergeTwoLists(leftLists: ListNode?, rightLists: ListNode?): ListNode? {
        if (leftLists == null) return rightLists
        if (rightLists == null) return leftLists

        return if (leftLists.`val` < rightLists.`val`) {
            leftLists.next = mergeTwoLists(leftLists.next, rightLists)
            leftLists
        } else {
            rightLists.next = mergeTwoLists(rightLists.next, leftLists)
            rightLists
        }
    }
}
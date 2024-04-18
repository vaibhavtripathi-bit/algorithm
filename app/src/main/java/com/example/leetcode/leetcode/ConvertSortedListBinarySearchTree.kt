package com.example.leetcode.leetcode

class ConvertSortedListBinarySearchTree {
    // 109 Convert Sorted List to Binary Search Tree
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        return sortedListToBST(head, null)
    }

    fun sortedListToBST(start: ListNode?, end: ListNode?): TreeNode? {
        if (start == end) return null

        var slow = start
        var fast = start

        while (fast != end && fast?.next != end) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var root = TreeNode(slow?.`val` ?: 0)
        root.left = sortedListToBST(start, slow)
        root.right = sortedListToBST(slow?.next, end)
        return root
    }

}
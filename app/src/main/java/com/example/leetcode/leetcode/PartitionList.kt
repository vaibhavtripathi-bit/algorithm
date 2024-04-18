package com.example.leetcode.leetcode

class PartitionList {
    // 86. Partition List
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head?.next == null) return head

        val beforeHead: ListNode? = ListNode(0)
        val afterHead:ListNode? = ListNode(0)
        var currentNode = head
        var before = beforeHead
        var after = afterHead

        while (currentNode != null) {
            if (currentNode.`val` < x ) {
                before?.next = currentNode
                before = before?.next
            } else {
                after?.next = currentNode
                after = after?.next
            }
            currentNode = currentNode.next
        }

        after?.next = null
        before?.next = afterHead?.next

        return beforeHead?.next
    }
}
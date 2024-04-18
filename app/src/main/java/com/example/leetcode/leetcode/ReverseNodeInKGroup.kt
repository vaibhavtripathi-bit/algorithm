package com.example.leetcode.leetcode

class ReverseNodeInKGroup {
    // 25 Reverse Nodes in k-Group
    //[1,2,3,4,5,6,7,8,9,10], k = 3
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        // Check if there are at least k nodes remaining
        if (!hasKNodesRemaining(head, k)) {
            return head
        }
        // Reverse first k nodes of the linked list
        val (newhead, nextGroup) = reverseFirstKNodes(head, k)
        /* Recursively call for the rest of the list and link the two lists */
        head?.next = reverseKGroup(nextGroup, k)

        return newhead
    }

    fun hasKNodesRemaining(head: ListNode?, k: Int): Boolean {
        var dummyNode: ListNode? = ListNode(0)
        dummyNode = head
        var count = 0
        while (dummyNode != null && count < k) {
            dummyNode = dummyNode?.next
            count++
        }
        return count == k
    }

    fun reverseFirstKNodes(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
        val dummyNode: ListNode? = ListNode(0)
        dummyNode?.next = head
        var current = head
        var previous: ListNode? = null
        var count = 0


        while (current != null && count < k) {
            val nextNode = current.next

            current.next = previous
            previous = current

            current = nextNode
            count++
        }
        return Pair(previous, current)
    }
}
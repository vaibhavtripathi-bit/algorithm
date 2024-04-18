package com.example.leetcode.leetcode

class SwapPair {
    //24 Swap Nodes in Pairs
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val dummy: ListNode? = ListNode(0)
        var currentNode = head
        var previousNode: ListNode? = null


        while (currentNode?.next != null) {
            val nextNode = currentNode.next
            val nextLoopCurrentNode = nextNode?.next

            currentNode.next = nextLoopCurrentNode
            nextNode?.next = currentNode

            if (previousNode == null) {
                dummy?.next = nextNode
            } else {
                previousNode.next = nextNode
            }

            previousNode = currentNode
            currentNode = currentNode.next
        }
        return dummy?.next
    }
}
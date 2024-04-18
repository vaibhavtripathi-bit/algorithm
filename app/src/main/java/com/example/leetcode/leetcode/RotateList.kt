package com.example.leetcode.leetcode

class RotateList {
    //61. Rotate List

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null

        val (currentNode, length) = getLength(head, k)
        //make it circular
        currentNode?.next = head
        val rotationLength = k % length
        val tailNode = findTailNode(head, length - rotationLength)

        return rotateList(tailNode)
    }

    private fun getLength(head: ListNode?, k: Int): Pair<ListNode?, Int> {
        var current = head
        var length = 1
        while (current?.next != null) {
            current = current.next
            length++
        }

        return Pair(current, length)
    }

    private fun findTailNode(head: ListNode?, rotationLength: Int): ListNode? {
        var currentNode = head

        for (index in 1..< rotationLength) {
            currentNode = currentNode?.next
        }
        return currentNode
    }

    private fun rotateList(tailNode: ListNode?): ListNode? {
        val newHead = tailNode?.next
        tailNode?.next = null
        return newHead
    }
}
package com.example.leetcode.leetcode

class MergeInBetweenLinkedLists {
    //1669. Merge In Between Linked Lists

    fun mergeInBetween(list1: ListNode?, startIndex: Int, endIndex: Int, list2: ListNode?): ListNode? {
        if (list1 == null || list2 == null) return list1 ?: list2

        val startPreviousNode = getPrevNode(list1, startIndex)
        val endNextNode = getNextNode(startPreviousNode, endIndex - startIndex + 1)
        val tailNode = getTailNode(list2)

        startPreviousNode?.next = list2
        tailNode?.next = endNextNode?.next
        endNextNode?.next = null

        return list1
    }

    private fun getPrevNode(head: ListNode?, startIndex: Int): ListNode? {
        var prev: ListNode? = ListNode(0)
        prev?.next = head
        var count = 0
        while (prev != null && count < startIndex) {
            prev = prev?.next
            count++
        }
        return prev
    }

    private fun getNextNode(head: ListNode?, length: Int): ListNode? {
        var next: ListNode? = head
        var count = 0
        while (next != null && count < length) {
            next = next?.next
            count++
        }
        return next
    }


    private fun getTailNode(head: ListNode?): ListNode? {
        var current = head
        while (current?.next != null) {
            current = current?.next
        }
        return current
    }
}

fun main() {
    val instance = MergeInBetweenLinkedLists()
    val head1 = ListNode(0)
    head1.next = ListNode(1)
    head1.next?.next = ListNode(2)
    head1.next?.next?.next = ListNode(3)
    head1.next?.next?.next?.next = ListNode(4)
    head1.next?.next?.next?.next?.next = ListNode(5)

    val head2 = ListNode(1000000)
    head2.next = ListNode(1000001)
    head2.next?.next = ListNode(1000002)

    val result = instance.mergeInBetween(head1, 3, 4, head2)
    var current = result
    while (current != null) {
        println(current.`val`)
        current = current.next
    }
    // Output: 0 1 2 1000000 1000001 1000002 5
}
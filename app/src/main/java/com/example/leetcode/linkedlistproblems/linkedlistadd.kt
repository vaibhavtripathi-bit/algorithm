package com.example.leetcode.linkedlistproblems

class linkedlistadd {
    // add two linked list
    // add two linked list using stack
    // add two linked list using recursion
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var carry = 0
        var l1 = l1
        var l2 = l2

        while (l1 != null || l2 != null || carry != 0) {
            val sum = (l1?.value ?: 0) + (l2?.value ?: 0) + carry
            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!
            l1 = l1?.next
            l2 = l2?.next
        }

        return dummy.next
    }

    fun mergeTwoLists(firstList: ListNode?, secondList: ListNode?): ListNode? {
        if (firstList == null) return secondList
        if (secondList == null) return firstList
        if (firstList.value < secondList.value) {
            firstList.next = mergeTwoLists(firstList.next, secondList)
            return firstList
        } else {
            secondList.next = mergeTwoLists(firstList, secondList.next)
            return secondList
        }
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        if (lists.size == 1) return lists[0]
        var result = lists[0]
        for (i in 1 until lists.size) {
            result = mergeTwoLists(result, lists[i])
        }
        return result
    }

    fun mergeTwoListInSortedOrder(firstList: ListNode?, secondList: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var first = firstList
        var second = secondList
        while (first != null && second != null) {
            if (first.value < second.value) {
                current.next = first
                first = first.next
            } else {
                current.next = second
                second = second.next
            }
            current = current.next!!
        }
        current.next = first ?: second
        return dummy.next
    }

}

fun main() {
    val linkedListAdd = linkedlistadd()
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))
    val result = linkedListAdd.addTwoNumbers(l1, l2)
    println(result?.value)
    println(result?.next?.value)
    println(result?.next?.next?.value)
}
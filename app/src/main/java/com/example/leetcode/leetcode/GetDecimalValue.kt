package com.example.leetcode.leetcode

import com.example.leetcode.linkedlistproblems.ListNode

class GetDecimalValue {
    fun getDecimalValue(head: ListNode?): Int {
        var result = 0
        var current = head
        while (current != null) {
            result = result shl 1 or current.value
            current = current.next
        }
        return result
    }

    fun main() {
        val head = ListNode(1)
        head.next = ListNode(0)
        head.next?.next = ListNode(1)
        println(getDecimalValue(head)) // Output: 5
    }

}
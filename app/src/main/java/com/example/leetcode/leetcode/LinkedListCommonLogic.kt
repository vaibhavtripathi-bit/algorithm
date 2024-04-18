package com.example.leetcode.leetcode

class LinkedListCommonLogic {
    fun moveNthNode(fastPointer: ListNode?, n: Int): ListNode? {
        var fast = fastPointer
        repeat(n - 1) {
            fast = fast?.next
        }
        return fast
    }

}
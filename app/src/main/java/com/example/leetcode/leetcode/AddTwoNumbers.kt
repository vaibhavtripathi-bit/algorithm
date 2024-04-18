package com.example.leetcode.leetcode


class AddTwoNumbers {
    class Solution {
        fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
            if (list1 == null && list2 == null) return null
            if (list1 == null) return list2
            if (list2 == null) return list1

            var dummyNode = ListNode(0)
            val finalList = dummyNode
            var carry = 0
            var node1: ListNode? = list1
            var node2: ListNode? = list2

            while (node1 != null || node2 != null || carry != 0) {
                val (sum, newCarry) = calculateSum(node1, node2, carry)
                carry = newCarry
                dummyNode = ListNode(sum).apply { dummyNode.next = this }
                node1 = node1?.next
                node2 = node2?.next
            }
            return finalList.next
        }

        private fun calculateSum(node1: ListNode?, node2: ListNode?, carry: Int): Pair<Int, Int> {
            var sum =  (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry
            val newCarry = sum / 10
            sum %= 10
            return Pair(sum, newCarry)
        }
    }
}
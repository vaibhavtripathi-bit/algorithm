package com.example.leetcode.leetcode

class IntersectionOfTwoLinkedLists {
    // 160. Intersection of Two Linked Lists

    // Time complexity O(n) and space complexity O(1)
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var pointerA = headA
        var pointerB = headB

        while (pointerA != pointerB) {
            pointerA = if (pointerA == null) headB else pointerA.next
            pointerB = if (pointerB == null) headA else pointerB.next
        }

        return pointerA
    }
}
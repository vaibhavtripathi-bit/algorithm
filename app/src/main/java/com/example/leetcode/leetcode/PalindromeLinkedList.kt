package com.example.leetcode.leetcode

class PalindromeLinkedList {
    // 234. Palindrome Linked List

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true // Single node or no node, it's a palindrome
        }

        val middle = findMiddle(head)
        val reversedSecondHalf = reverseList(middle)
        return compareLists(head, reversedSecondHalf)
    }

    private fun compareLists(l1: ListNode?, l2: ListNode?): Boolean {
        var list1 = l1
        var list2 = l2
        while (list1 != null && list2 != null) {
            if (list1.`val` != list2.`val`) {
                return false
            }
            list1 = list1.next
            list2 = list2.next
        }
        return true
    }

    private fun findMiddle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }
}

fun main() {
    val instance = PalindromeLinkedList()
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(1)
    println(instance.isPalindrome(head)) // Output: true
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next = ListNode(1)
    println(instance.isPalindrome(head)) // Output: true

}
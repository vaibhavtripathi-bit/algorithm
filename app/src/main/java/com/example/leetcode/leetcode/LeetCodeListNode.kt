package com.example.leetcode.leetcode

class ListNode {
    val `val`: Int
    var next: ListNode? = null

    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}


class TreeNode {
    var `val`: Int = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}

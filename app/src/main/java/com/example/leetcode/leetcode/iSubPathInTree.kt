package com.example.leetcode.leetcode

fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    return dfs(root, head)
}// Complexity O(n*m) and space O(n+m)

fun dfs(root: TreeNode?, head: ListNode?): Boolean {
    if (head == null) return true
    if (root == null) return false
    if (checkPathFromNode(root, head)) return true

    return dfs(root.left, head) || dfs(root.right, head)
}

fun checkPathFromNode(root: TreeNode?, head: ListNode?): Boolean {
    if (head == null) return true
    if (root == null || head.`val` != root.`val`) return false

    val isLeftPath = checkPathFromNode(root.left, head.next)
    val isRightPath = checkPathFromNode(root.right, head.next)
    val isPathExist = isLeftPath || isRightPath

    return isPathExist
}



// Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(4)
    root.left?.left = TreeNode(4)
    root.left?.left?.left = TreeNode(1)
    root.left?.left?.right = TreeNode(3)
    root.left?.right = TreeNode(2)
    root.left?.right?.left = TreeNode(6)
    root.left?.right?.right = TreeNode(8)
    root.right = TreeNode(4)
    root.right?.left = TreeNode(2)
    root.right?.left?.left = TreeNode(6)
    root.right?.right = TreeNode(3)

    val head = ListNode(1)
    head.next = ListNode(4)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(6)

    println(isSubPath(head, root)) // Output: true
}

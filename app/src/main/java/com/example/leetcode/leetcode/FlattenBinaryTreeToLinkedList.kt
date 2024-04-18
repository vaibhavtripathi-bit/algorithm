package com.example.leetcode.leetcode

class FlattenBinaryTreeToLinkedList {
    // 114. Flatten Binary Tree to Linked List
    fun flatten(root: TreeNode?): Unit {
        if (root == null) return

        flatten(root.left)
        flatten(root.right)

        val left = root.left
        val right = root.right

        root.left = null
        root.right = left

        var current = root
        while (current?.right != null) {
            current = current.right
        }
        current?.right = right
    }
}
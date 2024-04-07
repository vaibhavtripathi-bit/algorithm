package com.example.leetcode.tree

import com.example.leetcode.commondata.BinaryTreeNode

// provide solution for binary tree traversal inorder preorder postorder

// inorder: left -> root -> right
// preorder: root -> left -> right
// postorder: left -> right -> root

// binary tree node

// binary tree inorder traversal
fun inorderTraversalUsingStack(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = mutableListOf<BinaryTreeNode>()
    var current = root
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.add(current)
            current = current.left
        }
        current = stack.removeAt(stack.size - 1)
        result.add(current.value)
        current = current.right
    }
    return result
}

// binary tree preorder traversal

fun preorderTraversalUsingStack(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = mutableListOf<BinaryTreeNode>()
    var current = root
    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            result.add(current.value)
            stack.add(current)
            current = current.left
        }
        current = stack.removeAt(stack.size - 1)
        current = current.right
    }
    return result
}

// binary tree postorder traversal

fun postorderTraversalUsingStack(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) return result

    val stack1 = mutableListOf<BinaryTreeNode>()
    val stack2 = mutableListOf<BinaryTreeNode>()

    stack1.add(root)
    while (stack1.isNotEmpty()) {
        val node = stack1.removeAt(stack1.size - 1)
        stack2.add(node)

        node.left?.let { stack1.add(it) }
        node.right?.let { stack1.add(it) }
    }

    while (stack2.isNotEmpty()) {
        val node = stack2.removeAt(stack2.size - 1)
        result.add(node.value)
    }

    return result
}

fun inorderTraversalUsingQueue(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val queue = mutableListOf<BinaryTreeNode>()
    var current = root
    while (current != null || queue.isNotEmpty()) {
        while (current != null) {
            queue.add(current)
            current = current.left
        }
        current = queue.removeAt(0)
        result.add(current.value)
        current = current.right
    }
    return result
}

fun preorderTraversalUsingQueue(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val queue = mutableListOf<BinaryTreeNode>()
    var current = root
    while (current != null || queue.isNotEmpty()) {
        while (current != null) {
            result.add(current.value)
            queue.add(current)
            current = current.left
        }
        current = queue.removeAt(0)
        current = current.right
    }
    return result
}

fun postorderTraversalUsingQueue(root: BinaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val queue = mutableListOf<BinaryTreeNode>()
    var current = root
    var lastVisited: BinaryTreeNode? = null
    while (current != null || queue.isNotEmpty()) {
        while (current != null) {
            queue.add(current)
            current = current.left
        }
        current = queue[queue.size - 1]
        if (current.right == null || current.right == lastVisited) {
            result.add(current.value)
            queue.removeAt(queue.size - 1)
            lastVisited = current
            current = null
        } else {
            current = current.right
        }
    }
    return result
}


fun main() {
    val root = BinaryTreeNode(1)
    root.right = BinaryTreeNode(2)
    root.right!!.left = BinaryTreeNode(3)
    println(inorderTraversalUsingStack(root)) // Output: [1, 3, 2]
    println(preorderTraversalUsingStack(root)) // Output: [1, 2, 3]
    println(postorderTraversalUsingStack(root)) // Output: [3, 2, 1]
    val root2 = BinaryTreeNode(1)
    root2.left = BinaryTreeNode(2)
    root2.right = BinaryTreeNode(3)
    println(inorderTraversalUsingStack(root2)) // Output: [2, 1, 3]
    println(preorderTraversalUsingStack(root2)) // Output: [1, 2, 3]
    println(postorderTraversalUsingStack(root2)) // Output: [2, 3, 1]


    println(inorderTraversalUsingQueue(root)) // Output: [1, 3, 2]
    println(preorderTraversalUsingQueue(root)) // Output: [1, 2, 3]
    println(postorderTraversalUsingQueue(root)) // Output: [3, 2, 1]
}



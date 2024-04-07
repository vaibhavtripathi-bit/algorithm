package com.example.leetcode.tree

import com.example.leetcode.commondata.BinaryTreeNode

class TreeTraversal {
    fun inorderTraversal(root: BinaryTreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        binaryTreeTraversaldfs(root, result, "inorder")
        return result
    }

    fun preorderTraversal(root: BinaryTreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        binaryTreeTraversaldfs(root, result, "preorder")
        return result
    }

    fun postorderTraversal(root: BinaryTreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        binaryTreeTraversaldfs(root, result, "postorder")
        return result
    }

    private fun binaryTreeTraversaldfs(
        node: BinaryTreeNode?,
        result: MutableList<Int>,
        order: String
    ) {
        if (node == null) return
        when (order) {
            "inorder" -> {
                binaryTreeTraversaldfs(node.left, result, order)
                result.add(node.value)
                binaryTreeTraversaldfs(node.right, result, order)
            }

            "preorder" -> {
                result.add(node.value)
                binaryTreeTraversaldfs(node.left, result, order)
                binaryTreeTraversaldfs(node.right, result, order)
            }

            "postorder" -> {
                binaryTreeTraversaldfs(node.left, result, order)
                binaryTreeTraversaldfs(node.right, result, order)
                result.add(node.value)
            }
        }
    }

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
}

class TreeProperties {
    fun isSymmetric(root: BinaryTreeNode?): Boolean {
        return isMirror(root, root)
    }

    private fun isMirror(t1: BinaryTreeNode?, t2: BinaryTreeNode?): Boolean {
        if (t1 == null && t2 == null) return true
        if (t1 == null || t2 == null) return false
        return t1.value == t2.value && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left)
    }

    fun isBalanced(root: BinaryTreeNode?): Boolean {
        return maxDepthToCheckisBalanced(root) != -1
    }

    private fun maxDepthToCheckisBalanced(root: BinaryTreeNode?): Int {
        if (root == null) return 0
        val left = maxDepthToCheckisBalanced(root.left)
        val right = maxDepthToCheckisBalanced(root.right)
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1
        return 1 + maxOf(left, right)
    }

    fun isValidBST(node: BinaryTreeNode?, lower: Int?, upper: Int?): Boolean {
        if (node == null) return true

        val value = node.value

        if (lower != null && value <= lower) return false
        if (upper != null && value >= upper) return false

        if (!isValidBST(node.right, value, upper)) return false
        if (!isValidBST(node.left, lower, value)) return false
        return true
    }

    fun isSameTree(p: BinaryTreeNode?, q: BinaryTreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.value != q.value) return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    fun isSubtree(s: BinaryTreeNode?, t: BinaryTreeNode?): Boolean {
        if (s == null) return false
        if (isSameTree(s, t)) return true
        return isSubtree(s.left, t) || isSubtree(s.right, t)
    }
}

class TreeDepth {
    fun maxDepth(root: BinaryTreeNode?): Int {
        if (root == null) return 0
        return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }

    fun minDepth(root: BinaryTreeNode?): Int {
        if (root == null) return 0
        if (root.left == null) return 1 + minDepth(root.right)
        if (root.right == null) return 1 + minDepth(root.left)
        return 1 + minOf(minDepth(root.left), minDepth(root.right))
    }
}

fun main() {

    val root = BinaryTreeNode(1)
    root.right = BinaryTreeNode(2)
    root.right!!.left = BinaryTreeNode(3)
    val treeTraversal = TreeTraversal()
    println(treeTraversal.inorderTraversal(root)) // Output: [1, 3, 2]
    println(treeTraversal.preorderTraversal(root)) // Output: [1, 2, 3]
    println(treeTraversal.postorderTraversal(root)) // Output: [3, 2, 1]
    val root2 = BinaryTreeNode(1)
    root2.left = BinaryTreeNode(2)
    root2.right = BinaryTreeNode(3)
    val treeProperties = TreeProperties()
    println(treeProperties.isSymmetric(root)) // Output: false
    println(treeProperties.isSymmetric(root2)) // Output: true
    println(treeProperties.isBalanced(root)) // Output: false
    println(treeProperties.isBalanced(root2)) // Output: true
    println(treeProperties.isValidBST(root, null, null)) // Output: false
    println(treeProperties.isValidBST(root2, null, null)) // Output: true
    val root3 = BinaryTreeNode(1)
    root3.left = BinaryTreeNode(2)
    root3.right = BinaryTreeNode(3)
    val root4 = BinaryTreeNode(1)
    root4.left = BinaryTreeNode(2)
    root4.right = BinaryTreeNode(3)
    println(treeProperties.isSameTree(root3, root4)) // Output: true
    println(treeProperties.isSubtree(root3, root4)) // Output: true
    val treeDepth = TreeDepth()
    println(treeDepth.maxDepth(root)) // Output: 3
    println(treeDepth.minDepth(root)) // Output: 2
    println(treeDepth.maxDepth(root2)) // Output: 2
    println(treeDepth.minDepth(root2)) // Output: 2
    println(treeDepth.maxDepth(root3)) // Output: 2
    println(treeDepth.minDepth(root3)) // Output: 2
    println(treeDepth.maxDepth(root4)) // Output: 2
    println(treeDepth.minDepth(root4)) // Output: 2
}
// Output: 3

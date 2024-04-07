package com.example.leetcode.tree

import com.example.leetcode.commondata.BinaryTreeNode

// calculate the max depth of a binary tree

fun maxDepth(root: BinaryTreeNode?): Int {
    if (root == null) return 0
    return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
}

// other tree problems

// calculate the min depth of a binary tree
fun minDepth(root: BinaryTreeNode?): Int {
    if (root == null) return 0
    if (root.left == null) return 1 + minDepth(root.right)
    if (root.right == null) return 1 + minDepth(root.left)
    return 1 + minOf(minDepth(root.left), minDepth(root.right))
}

// check if a binary tree is symmetric

fun isSymmetric(root: BinaryTreeNode?): Boolean {
    return isMirror(root, root)
}

// check if two binary trees are mirror of each other
fun isMirror(t1: BinaryTreeNode?, t2: BinaryTreeNode?): Boolean {
    if (t1 == null && t2 == null) return true
    if (t1 == null || t2 == null) return false
    return t1.value == t2.value && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left)
}

// check if a binary tree is balanced
// Balanced has a height difference of 1 or less between the left and right subtree
fun isBalanced(root: BinaryTreeNode?): Boolean {
    return maxDepthToCheckisBalanced(root) != -1
}

fun maxDepthToCheckisBalanced(root: BinaryTreeNode?): Int {
    if (root == null) return 0
    val left = maxDepthToCheckisBalanced(root.left)
    val right = maxDepthToCheckisBalanced(root.right)
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1
    return 1 + maxOf(left, right)
}

// check if a binary tree is a valid binary search tree
// A valid BST has the left subtree values less than the root value and right subtree values greater than the root value
fun isValidBST(node: BinaryTreeNode?, lower: Int?, upper: Int?): Boolean {
    if (node == null) return true

    val value = node.value

    if (lower != null && value <= lower) return false
    if (upper != null && value >= upper) return false

    if (!isValidBST(node.right, value, upper)) return false
    if (!isValidBST(node.left, lower, value)) return false
    return true
}

// other tree problems

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

fun hasPathSum(root: BinaryTreeNode?, sum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) return sum == root.value
    val left = hasPathSum(root.left, sum - root.value)
    val right = hasPathSum(root.right, sum - root.value)
    return left || right
}

fun hasPathSumUsingStack(root: BinaryTreeNode?, sum: Int): Boolean {
    if (root == null) return false
    val stack = mutableListOf<Pair<BinaryTreeNode, Int>>()
    stack.add(Pair(root, sum - root.value))
    while (stack.isNotEmpty()) {
        val (node, currentSum) = stack.removeAt(stack.size - 1)
        if (node.left == null && node.right == null && currentSum == 0) return true
        if (node.left != null) stack.add(Pair(node.left!!, currentSum - node.left!!.value))
        if (node.right != null) stack.add(Pair(node.right!!, currentSum - node.right!!.value))
    }
    return false
}



fun main() {
    val root = BinaryTreeNode(3)
    root.left = BinaryTreeNode(9)
    root.right = BinaryTreeNode(20)
    root.right!!.left = BinaryTreeNode(15)
    root.right!!.right = BinaryTreeNode(7)
    println(maxDepth(root)) // Output: 3

    isSymmetric(root)
    println(isSymmetric(root)) // Output: false
}


// Output: 3

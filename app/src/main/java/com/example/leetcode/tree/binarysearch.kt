package com.example.leetcode.tree

import com.example.leetcode.commondata.BinaryTreeNode

// provide solution for binary serach problems

fun searchBST(root: BinaryTreeNode?, `val`: Int): BinaryTreeNode? {
    if (root == null) return null
    if (root.value == `val`) return root
    return if (`val` < root.value) searchBST(root.left, `val`) else searchBST(root.right, `val`)
}

fun insertIntoBST(root: BinaryTreeNode?, `val`: Int): BinaryTreeNode? {
    if (root == null) return BinaryTreeNode(`val`)
    if (`val` < root.value) {
        root.left = insertIntoBST(root.left, `val`)
    } else {
        root.right = insertIntoBST(root.right, `val`)
    }
    return root
}

fun deleteNode(root: BinaryTreeNode?, key: Int): BinaryTreeNode? {
    if (root == null) return null
    if (root.value == key) {
        if (root.left == null) return root.right
        if (root.right == null) return root.left
        var minNode = root.right
        while (minNode!!.left != null) {
            minNode = minNode.left
        }
        root.value = minNode.value
        root.right = deleteNode(root.right, minNode.value)
    } else if (key < root.value) {
        root.left = deleteNode(root.left, key)
    } else {
        root.right = deleteNode(root.right, key)
    }
    return root
}

// more problem which can be solved using binary search

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size
    var left = 0
    var right = m * n - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val midValue = matrix[mid / n][mid % n]
        if (midValue == target) return true
        if (midValue < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return false
}

fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size
    var row = 0
    var col = n - 1
    while (row < m && col >= 0) {
        if (matrix[row][col] == target) return true
        if (matrix[row][col] < target) {
            row++
        } else {
            col--
        }
    }
    return false
}

// problem which can be solved using binary search

fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2) { -1 }
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            var start = mid
            var end = mid
            while (start >= 0 && nums[start] == target) {
                start--
            }
            while (end < nums.size && nums[end] == target) {
                end++
            }
            result[0] = start + 1
            result[1] = end - 1
            return result
        }
        if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return result
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left
}

fun findPeakElement(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] < nums[right]) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[left]
}

// problem which can be solved using binary search





package com.example.leetcode.leetcode

class PopulatingNextRightPointersinEachNode {
    // 116. Populating Next Right Pointers in Each Node
    fun connect(root: Node?): Node? {
        if (root == null) return null

        if (root.left != null) {
            root.left?.next = root.right
            if (root.next != null) {
                root.right?.next = root.next?.left
            }
        }

        connect(root.left)
        connect(root.right)

        return root
    }

    fun connect1(root: Node?): Node? {
        if (root == null) return root

        var levelStart = root

        while (levelStart != null) {
            var currentNode = levelStart

            while (currentNode != null) {
                if (currentNode.left != null) {
                    currentNode.left?.next = currentNode?.right
                }
                if (currentNode.right != null && currentNode.next != null) {
                    currentNode.right?.next = currentNode?.next?.left
                }
                currentNode = currentNode?.next
            }
            levelStart = levelStart?.left
        }
        return root
    }

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null

        constructor(`val`: Int, left: Node?, right: Node?, next: Node?) : this(`val`) {
            this.`val` = `val`
            this.left = left
            this.right = right
            this.next = next
        }
    }

    // 117. Populating Next Right Pointers in Each Node II

    fun connect2(root: Node?): Node? {
        if (root == null) return null

        var levelStart = root

        while (levelStart != null) {
            var current: Node? = levelStart
            var dummyHead = Node(0) // Dummy head for the level
            var tail: Node? = dummyHead

            while (current != null) {
                if (current.left != null) {
                    tail?.next = current.left
                    tail = tail?.next
                }
                if (current.right != null) {
                    tail?.next = current.right
                    tail = tail?.next
                }
                current = current.next
            }

            // Move to the next level's start node
            levelStart = dummyHead.next
        }
        return root
    }

    fun connect2Recursive(root: Node?): Node? {
        if (root == null) return null

        var levelStart = root
        var dummy = Node(0)
        var current = dummy

        while (levelStart != null) {
            if (levelStart.left != null) {
                current.next = levelStart.left
                current = current.next!!
            }
            if (levelStart.right != null) {
                current.next = levelStart.right
                current = current.next!!
            }
            levelStart = levelStart.next
        }
        connect2Recursive(dummy.next)
        return root
    }


}
package com.example.leetcode.leetcode

class CopyListWithRandomPointer {

    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }
    // 138. Copy List with Random Pointer

    // Step 1: Function to create a deep copy of each node and insert it next to the original node
    fun copyAndInsertNext(original: Node?) {
        var current = original
        while (current != null) {
            val copy = Node(current.`val`)
            copy.next = current.next
            current.next = copy
            current = copy.next
        }
    }

    // Step 2: Function to update the random pointers of copied nodes
    fun updateRandomPointers(original: Node?) {
        var current = original
        while (current != null) {
            current.next?.random = current.random?.next // Update random pointer of copied node
            current = current.next?.next
        }
    }

    // Step 3: Function to separate the original and copied lists
    fun separateLists(original: Node?): Node? {
        var current = original
        val newHead = original?.next
        var newCurrent: Node? = newHead
        while (current != null) {
            current.next = current.next?.next
            newCurrent?.next = newCurrent?.next?.next
            current = current.next
            newCurrent = newCurrent?.next
        }
        return newHead
    }

    // Main function to perform deep copy of the linked list with random pointers
    fun copyRandomList(head: Node?): Node? {
        if (head == null) return null

        // Step 1: Create a deep copy of each node and insert it next to the original node
        copyAndInsertNext(head)

        // Step 2: Update the random pointers of copied nodes
        updateRandomPointers(head)

        // Step 3: Separate the original and copied lists
        return separateLists(head)
    }

}
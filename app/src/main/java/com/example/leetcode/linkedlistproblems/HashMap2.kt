package com.example.leetcode.linkedlistproblems

class MyHashMap2 {

    // Define a node class for the linked list
    data class Node(val key: Int, var value: Int, var next: Node? = null)

    // Define the size of the hash table
    private val size = 1000

    // Define an array to store linked lists (buckets)
    private val mapArray = Array<Node?>(size) { null }

    // Hash function to calculate index
    private fun hash(key: Int): Int {
        return key % size
    }

    fun put(key: Int, value: Int) {
        val index = hash(key)
        val newNode = Node(key, value)

        // Check if the bucket is empty
        if (mapArray[index] == null) {
            mapArray[index] = newNode
        } else {
            // Traverse the linked list to find the end
            var current = mapArray[index]
            while (current?.next != null) {
                if (current.key == key) {
                    // If key exists, update value
                    current.value = value
                    return
                }
                current = current.next
            }
            // Append new node to the end of the linked list
            current?.next = newNode
        }
    }

    fun get(key: Int): Int {
        val index = hash(key)
        var current = mapArray[index]

        // Traverse the linked list to find the key
        while (current != null) {
            if (current.key == key) {
                return current.value
            }
            current = current.next
        }
        return -1 // Return -1 if key not found
    }

    fun remove(key: Int) {
        val index = hash(key)
        var current = mapArray[index]
        var prev: Node? = null

        // Traverse the linked list to find the key
        while (current != null) {
            if (current.key == key) {
                // Remove the node
                if (prev == null) {
                    mapArray[index] = current.next
                } else {
                    prev.next = current.next
                }
                return
            }
            prev = current
            current = current.next
        }
    }
}
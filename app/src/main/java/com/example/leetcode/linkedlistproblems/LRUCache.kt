package com.example.leetcode.linkedlistproblems

class LRUCache(private val capacity: Int) {
    private data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )

    private val map = HashMap<Int, Node>(capacity)
    private var head: Node? = null
    private var tail: Node? = null

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map[key]!!
            node.value = value
            moveToHead(node)
        } else {
            if (map.size >= capacity) {
                map.remove(tail?.key)
                removeNode(tail)
            }
            val newNode = Node(key, value)
            map[key] = newNode
            addToHead(newNode)
        }
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun addToHead(node: Node) {
        node.prev = null
        node.next = head
        if (head != null) {
            head!!.prev = node
        } else {
            tail = node
        }
        head = node
    }

    private fun removeNode(node: Node?) {
        if (node?.prev != null) {
            node.prev!!.next = node.next
        } else {
            head = node?.next
        }
        if (node?.next != null) {
            node.next!!.prev = node.prev
        } else {
            tail = node?.prev
        }
    }
}
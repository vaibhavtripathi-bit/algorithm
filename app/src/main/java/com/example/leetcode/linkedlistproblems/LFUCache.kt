package com.example.leetcode.linkedlistproblems

import java.util.PriorityQueue


internal class LFUCache(private val capacity: Int) {
    internal inner class Node(var key: Int, var value: Int) {
        var count = 1
        var index = 0
    }

    private val cache: MutableMap<Int, Node>
    private val queue: PriorityQueue<Node?>
    private var index = 0

    init {
        cache = HashMap()
        queue = PriorityQueue(object : Comparator<Node?> {
            override fun compare(node1: Node?, node2: Node?): Int {
                if (node1 == null || node2 == null) return 0
                val diff = node1.count - node2.count
                return if (diff == 0) {
                    node1.index - node2.index
                } else diff
            }
        })
    }

    operator fun get(key: Int): Int {
        if (!cache.containsKey(key)) {
            return -1
        }
        val node = cache[key]
        node!!.count++
        node.index = ++index
        queue.remove(node)
        queue.offer(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        if (cache.containsKey(key)) {
            val node = cache[key]
            node!!.value = value
            node.count++
            node.index = ++index
            queue.remove(node)
            queue.offer(node)
        } else {
            if (cache.size == capacity) {
                val node = queue.poll()
                cache.remove(node!!.key)
            }
            val node: Node = Node(key, value)
            node.index = ++index
            cache[key] = node
            queue.offer(node)
        }
    }
}
package com.example.leetcode.linkedlistproblems

class LFUCache5(private val capacity: Int) {
    private val nodeMap = mutableMapOf<Int, Node>()
    private val countMap = mutableMapOf<Int, LinkedHashSet<Node>>()
    private var min = -1

    data class Node(var key: Int, var value: Int, var count: Int = 1)

    fun get(key: Int): Int {
        val node = nodeMap[key] ?: return -1
        update(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return
        if (nodeMap.containsKey(key)) {
            val node = nodeMap[key]!!
            node.value = value
            update(node)
        } else {
            if (nodeMap.size >= capacity) {
                val node = countMap[min]!!.first()
                countMap[min]!!.remove(node)
                nodeMap.remove(node.key)
            }
            val newNode = Node(key, value)
            nodeMap[key] = newNode
            countMap[1] = countMap.getOrDefault(1, LinkedHashSet())
            countMap[1]!!.add(newNode)
            min = 1
        }
    }

    private fun update(node: Node) {
        val count = node.count
        countMap[count]!!.remove(node)
        if (count == min && countMap[count]!!.isEmpty()) {
            min++
        }
        node.count++
        countMap[node.count] = countMap.getOrDefault(node.count, LinkedHashSet())
        countMap[node.count]!!.add(node)
    }
}
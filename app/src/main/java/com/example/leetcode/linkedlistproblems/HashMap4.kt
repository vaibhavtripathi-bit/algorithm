package com.example.leetcode.linkedlistproblems

class MyHashMap4() {
    private val nodes = arrayOfNulls<Node>(10000)
    fun test() {
        val nodes = Array<Node?>(10000) { null }
        val nodes1 = (0 until 10000).map { Node(1, 1,null) }.toTypedArray()
        val nodes2 = Array<Node?>(10000) { null }.apply { fill(null) }
        val nodes3 = Array<Node?>(10000) { null }
        for (i in nodes.indices) {
            nodes[i] = null
        }
    }

    fun put(key: Int, value: Int) {
        val index = getIndex(key)
        val prev = findElement(index, key)
        if (prev?.next == null) {
            prev?.next = Node(key, value, null)
        } else {
            prev.next?.value = value
        }
    }

    fun get(key: Int): Int {
        val index = getIndex(key)
        val node = findElement(index, key)
        return node?.next?.value ?: -1
    }

    fun remove(key: Int) {
        val index = getIndex(key)
        val prev = findElement(index, key)
        prev?.next = prev?.next?.next
    }

    private fun getIndex(key: Int): Int {
        return Integer.hashCode(key) % nodes.size
    }

    private fun findElement(index: Int, key: Int): Node? {
        if (nodes[index] == null) {
            nodes[index] = Node(-1, -1, null)
            return nodes[index]
        }
        var prev = nodes[index]
        while (prev?.next != null && prev.next?.key != key) {
            prev = prev.next
        }
        return prev
    }

    class Node(var key: Int, var value: Int, var next: Node?)
}
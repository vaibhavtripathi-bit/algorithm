package com.example.leetcode.linkedlistproblems

class LFUCache4(private val capacity: Int) {

    private val cache: MutableMap<Int, Int> = mutableMapOf()
    private val frequency: MutableMap<Int, Int> = mutableMapOf()
    private val frequencyLists: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    private var minFrequency = 0

    init {
        frequencyLists[1] = mutableSetOf()
    }

    fun get(key: Int): Int {
        if (!cache.containsKey(key)) {
            return -1
        }
        val value = cache[key]!!
        updateFrequency(key)
        return value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return
        if (cache.containsKey(key)) {
            cache[key] = value
            updateFrequency(key)
            return
        }
        if (cache.size >= capacity) {
            evict()
        }
        cache[key] = value
        frequency[key] = 1
        frequencyLists.getOrPut(1) { mutableSetOf() }.add(key)
        minFrequency = 1
    }

    private fun evict() {
        val evictKey = frequencyLists[minFrequency]!!.iterator().next()
        cache.remove(evictKey)
        frequency.remove(evictKey)
        frequencyLists[minFrequency]!!.remove(evictKey)
        if (frequencyLists[minFrequency]!!.isEmpty()) {
            frequencyLists.remove(minFrequency)
        }
    }

    private fun updateFrequency(key: Int) {
        val freq = frequency[key]!!
        frequency[key] = freq + 1
        frequencyLists[freq]!!.remove(key)
        if (freq == minFrequency && frequencyLists[freq]!!.isEmpty()) {
            minFrequency++
        }
        frequencyLists.getOrPut(freq + 1) { mutableSetOf() }.add(key)
    }
}

fun main() {
    val cache = LFUCache4(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1)) // returns 1
    cache.put(3, 3) // evicts key 2
    println(cache.get(2)) // returns -1 (not found)
    println(cache.get(3)) // returns 3.
    cache.put(4, 4) // evicts key 1.
    println(cache.get(1)) // returns -1 (not found)
    println(cache.get(3)) // returns 3
    println(cache.get(4)) // returns 4
}

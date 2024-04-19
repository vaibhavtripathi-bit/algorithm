package com.example.leetcode.linkedlistproblems


class LFUCache2(private val capacity: Int) {
    private val keyToValue = mutableMapOf<Int, Int>()
    private val keyToFreq = mutableMapOf<Int, Int>()
    private val freqToKeys = mutableMapOf<Int, LinkedHashSet<Int>>()
    private var minFreq = 0

    fun get(key: Int): Int {
        if (!keyToValue.containsKey(key)) return -1

        increaseFrequency(key)
        return keyToValue[key]!!
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) return

        if (keyToValue.containsKey(key)) {
            keyToValue[key] = value
            increaseFrequency(key)
            return
        }

        if (keyToValue.size >= capacity) {
            evictLeastFrequent()
        }

        keyToValue[key] = value
        keyToFreq[key] = 1
        freqToKeys.getOrPut(1) { linkedSetOf() }.add(key)
        minFreq = 1
    }

    private fun increaseFrequency(key: Int) {
        val freq = keyToFreq[key]!!
        keyToFreq[key] = freq + 1
        freqToKeys[freq]!!.remove(key)
        freqToKeys.getOrPut(freq + 1) { linkedSetOf() }.add(key)
        if (freq == minFreq && freqToKeys[freq]!!.isEmpty()) {
            minFreq++
        }
    }

    private fun evictLeastFrequent() {
        val keys = freqToKeys[minFreq]!!
        val evictKey = keys.iterator().next()
        keys.remove(evictKey)
        keyToValue.remove(evictKey)
        keyToFreq.remove(evictKey)
    }
}
package com.example.leetcode.linkedlistproblems

class MyHashSet() {
    private val boolArray = BooleanArray(1000001).apply { fill(false) }
    //private val array = Array<Boolean?>(1000001) { null }

    fun add(key: Int) {
        boolArray[key] = true
    }

    fun remove(key: Int) {
        boolArray[key] = false
    }

    fun contains(key: Int): Boolean {
        return boolArray[key]
    }
}

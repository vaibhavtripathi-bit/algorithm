package com.example.leetcode.linkedlistproblems

class HashMap3() {

    // Define the size of the hash table
    private val size = 1000

    // Define an array to store ArrayLists (buckets)
    private val mapArray = Array<ArrayList<Pair<Int, Int>>>(size) { ArrayList() }

    // Hash function to calculate index
    private fun hash(key: Int): Int {
        return key % size
    }

    fun put(key: Int, value: Int) {
        val index = hash(key)
        val bucket = mapArray[index]

        // Check if the key already exists in the bucket
        for (i in bucket.indices) {
            if (bucket[i].first == key) {
                // If key exists, update value
                bucket[i] = Pair(key, value)
                return
            }
        }

        // If key doesn't exist, add new key-value pair to the bucket
        bucket.add(Pair(key, value))
    }

    fun get(key: Int): Int {
        val index = hash(key)
        val bucket = mapArray[index]

        // Search for the key in the bucket
        for (pair in bucket) {
            if (pair.first == key) {
                return pair.second // Return the corresponding value if key found
            }
        }
        return -1 // Return -1 if key not found
    }

    fun remove(key: Int) {
        val index = hash(key)
        val bucket = mapArray[index]

        // Search for the key in the bucket
        for (i in bucket.indices) {
            if (bucket[i].first == key) {
                // If key found, remove the key-value pair from the bucket
                bucket.removeAt(i)
                return
            }
        }
    }
}
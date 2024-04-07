package com.example.leetcode.string

class findanagram {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pMap = mutableMapOf<Char, Int>()
        p.forEach {
            pMap[it] = pMap.getOrDefault(it, 0) + 1
        }
        var start = 0
        var end = 0
        var count = pMap.size
        while (end < s.length) {
            val endChar = s[end]
            if (pMap.containsKey(endChar)) {
                pMap[endChar] = pMap[endChar]!! - 1
                if (pMap[endChar] == 0) count--
            }
            end++
            while (count == 0) {
                val startChar = s[start]
                if (pMap.containsKey(startChar)) {
                    pMap[startChar] = pMap[startChar]!! + 1
                    if (pMap[startChar]!! > 0) count++
                }
                if (end - start == p.length) {
                    result.add(start)
                }
                start++
            }
        }
        return result
    }

    fun findAnagramUsingSet(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pSet = p.toSet()
        var start = 0
        var end = 0
        while (end < s.length) {
            val endChar = s[end]
            if (pSet.contains(endChar)) {
                end++
            } else {
                start = end + 1
                end = start
            }
            if (end - start == p.length) {
                result.add(start)
                start++
                end = start
            }
        }
        return result
    }

    fun findAnagramUsingMap(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pMap = mutableMapOf<Char, Int>()
        p.forEach {
            pMap[it] = pMap.getOrDefault(it, 0) + 1
        }
        var start = 0
        var end = 0
        while (end < s.length) {
            val endChar = s[end]
            if (pMap.containsKey(endChar)) {
                pMap[endChar] = pMap[endChar]!! - 1
                if (pMap[endChar] == 0) pMap.remove(endChar)
                end++
            } else {
                start = end + 1
                end = start
            }
            if (pMap.isEmpty()) {
                result.add(start)
                start++
                end = start
            }
        }
        return result
    }

    fun findAnagramUsingArray(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pArray = IntArray(26)
        p.forEach {
            pArray[it - 'a']++
        }
        var start = 0
        var end = 0
        var count = p.length
        while (end < s.length) {
            val endChar = s[end]
            if (pArray[endChar - 'a'] > 0) {
                pArray[endChar - 'a']--
                count--
            }
            end++
            while (count == 0) {
                val startChar = s[start]
                if (pArray[startChar - 'a'] == 0) {
                    result.add(start)
                    count++
                }
                pArray[startChar - 'a']++
                start++
            }
        }
        return result
    }

}
package com.example.leetcode.string

class reversestring {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }

    fun reverseStringUsingRecursion(s: CharArray): Unit {
        reverse(s, 0, s.size - 1)
    }

    fun reverse(s: CharArray, left: Int, right: Int) {
        if (left >= right) return
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
        reverse(s, left + 1, right - 1)
    }

}
package com.example.leetcode.palindrome

// palindromenumber class provide solution for palindrome number

class palindromenumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var num = x
        var reversed = 0
        while (num != 0) {
            if (reversed > Int.MAX_VALUE / 10) {
                return false
            }
            reversed = reversed * 10 + num % 10
            num /= 10
        }
        return x == reversed
    }

    fun isPalindrome2(x: Int): Boolean {
        if (x < 0) return false
        return x == reverseInteger(x)
    }

    fun reverseInteger(x: Int): Int {
        var num = x
        var reversed = 0L
        while (num != 0) {
            val pop = num % 10
            num /= 10
            if (checkOverflow(reversed, pop)) return 0
            reversed = reversed * 10 + pop
        }
        return reversed.toInt()
    }

    fun checkOverflow(reversed: Long, pop: Int): Boolean {
        if (reversed > Int.MAX_VALUE / 10
            || (reversed.toInt() == Int.MAX_VALUE / 10 && pop > 7))
            return true
        if (reversed < Int.MIN_VALUE / 10
            || (reversed.toInt() == Int.MIN_VALUE / 10 && pop < -8))
            return true
        return false
    }

    fun findPalindromeInString(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }

    // more palindrome related problems

    fun longestPalindromicSubstring(s: String): String {
        if (s.isEmpty()) return ""
        var start = 0
        var end = 0
        for (i in s.indices) {
            val len1 = expandAroundCenter(s, i, i)
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = maxOf(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)
    }

    fun expandAroundCenter(s: String, aleft: Int, aright: Int): Int {
        var left = aleft
        var right = aright
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--
            right++
        }
        return right - left - 1
    }

    fun isPalindromeString(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }

    fun isPalindromeNumber(x: Int): Boolean {
        if (x < 0) return false
        var num = x
        var reversed = 0
        while (num != 0) {
            if (reversed > Int.MAX_VALUE / 10) {
                return false
            }
            reversed = reversed * 10 + num % 10
            num /= 10
        }
        return x == reversed
    }
    // more palindrome related problems


}

fun checkOverflow(reversed: Long, pop: Int): Boolean {
    if (reversed > Int.MAX_VALUE / 10
        || (reversed.toInt() == Int.MAX_VALUE / 10 && pop > 7))
        return true
    if (reversed < Int.MIN_VALUE / 10
        || (reversed.toInt() == Int.MIN_VALUE / 10 && pop < -8))
        return true
    return false
}


fun main() {
    val palindromeNumber = palindromenumber()
    val result = palindromeNumber.isPalindrome(121)
    println(result)
}

// Output: true
// Explanation: 121 is a palindrome number because the reverse of 121 is 121.
// Therefore, the output is true.
//
package com.example.leetcode.dynamicprogramming

// 128 longest consecutive sequence

fun longestConsecutive(nums: IntArray): Int {
    val numSet = nums.toHashSet()
    var longestStreak = 0

    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            val currentStreak = calculateStreak(numSet, num)
            longestStreak = maxOf(longestStreak, currentStreak)
        }
    }

    return longestStreak
}

fun isStartOfSequence(numSet: HashSet<Int>, num: Int): Boolean {
    return !numSet.contains(num - 1)
}

fun calculateStreak(numSet: HashSet<Int>, startNum: Int): Int {
    var currentNum = startNum
    var currentStreak = 1

    while (numSet.contains(currentNum + 1)) {
        currentNum++
        currentStreak++
    }

    return currentStreak
}


fun longestConsecutiveSequenceUsingSorting(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    nums.sort()
    var longestStreak = 1
    var currentStreak = 1

    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {       // if the current number is not equal to the previous number, then we have found a new sequence
            if (nums[i] == nums[i - 1] + 1) {   // if the current number is the next number in the sequence, then we increment the current streak
                currentStreak++                 // increment the current streak, as we have found the next number in the sequence
            } else {
                longestStreak = maxOf(longestStreak, currentStreak)
                currentStreak = 1
            }
        }
    }

    return maxOf(longestStreak, currentStreak)
}

fun main() {
    val nums = intArrayOf(100, 4, 200, 1, 3, 2)
    val result = longestConsecutive(nums)
    println(result)
}

// Output: 4
// Time complexity: O(n)
// Space complexity: O(n)
// leetcode link: https://leetcode.com/problems/longest-consecutive-sequence/

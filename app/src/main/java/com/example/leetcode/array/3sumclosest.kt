package com.example.leetcode.array

class threesumclosest {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closestSum = Int.MAX_VALUE
        var closestDiff = Int.MAX_VALUE
        for (i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                val diff = Math.abs(target - sum)
                if (diff < closestDiff) {
                    closestDiff = diff
                    closestSum = sum
                }
                if (sum < target) {
                    left++
                } else {
                    right--
                }
            }
        }
        return closestSum
    }


}

fun main() {
    val threesumclosest = threesumclosest()
    println(threesumclosest.threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))  // Output: 2
    println(threesumclosest.threeSumClosest(intArrayOf(0, 0, 0), 1))  // Output: 0
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), -100))  // Output: 2
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 100))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 0))  // Output: 2
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 1))  // Output: 2
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 2))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 3))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 4))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 5))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 6))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 7))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 8))  // Output: 3
    println(threesumclosest.threeSumClosest(intArrayOf(1, 1, 1, 0), 9))  // Output: 3
}
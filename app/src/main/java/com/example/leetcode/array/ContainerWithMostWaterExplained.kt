package com.example.leetcode.array

class ContainerWithMostWaterExplained {

    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            val currentArea = (right - left) * Math.min(height[left], height[right])
            maxArea = Math.max(maxArea, currentArea)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }


}

fun main() {
    val containerWithMostWaterExplained = ContainerWithMostWaterExplained()
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))  // Output: 49
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 1)))  // Output: 1
    println(containerWithMostWaterExplained.maxArea(intArrayOf(4, 3, 2, 1, 4)))  // Output: 16
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 2, 1)))  // Output: 2
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))  // Output: 49
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 1)))  // Output: 1
    println(containerWithMostWaterExplained.maxArea(intArrayOf(4, 3, 2, 1, 4)))  // Output: 16
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 2, 1)))  // Output: 2
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))  // Output: 49
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 1)))  // Output: 1
    println(containerWithMostWaterExplained.maxArea(intArrayOf(4, 3, 2, 1, 4)))  // Output: 16
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 2, 1)))  // Output: 2
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))  // Output: 49
    println(containerWithMostWaterExplained.maxArea(intArrayOf(1, 1)))  // Output: 1
}
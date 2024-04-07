package com.example.leetcode.array

class squareofsortedarray {

    fun sortedSquares(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        var left = 0
        var right = n - 1
        var index = n - 1
        while (left <= right) {
            val leftSquare = nums[left] * nums[left]
            val rightSquare = nums[right] * nums[right]
            if (leftSquare > rightSquare) {
                result[index] = leftSquare
                left++
            } else {
                result[index] = rightSquare
                right--
            }
            index--
        }
        return result
    }

    fun sortedSquaresUsingSort(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }

}

fun testSquareOfSortedArray() {
    val squareofsortedarray = squareofsortedarray()
    val result = squareofsortedarray.sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
    println(result.toList()) // Output: [0, 1, 9, 16, 100]
    val result2 = squareofsortedarray.sortedSquaresUsingSort(intArrayOf(-7, -3, 2, 3, 11))
    println(result2.toList()) // Output: [4, 9, 9, 49, 121]
}

fun main() {
    testSquareOfSortedArray()
}

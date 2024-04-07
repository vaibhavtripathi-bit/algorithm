package com.example.leetcode.random

// pascal triangle leetcode 118

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (numRows == 0) return result

    result.add(listOf(1))
    for (i in 1 until numRows) {
        val prevRow = result[i - 1]         // get the previous row, which is the last row in the result
        val row = mutableListOf<Int>()
        row.add(1)
        for (j in 1 until i) {              // iterate from 1 to i - 1, because the first and last element is always 1
            row.add(prevRow[j - 1] + prevRow[j])    // add the sum of the previous row's jth and j-1th element, because the current row's jth element is the sum of the previous row's jth and j-1th element
        }
        row.add(1)
        result.add(row)
    }
    return result
}

fun main() {
    println(generate(5)) // Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
}

// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Time complexity: O(n^2)
// Space complexity: O(n^2)
// leetcode link: https://leetcode.com/problems/pascals-triangle/


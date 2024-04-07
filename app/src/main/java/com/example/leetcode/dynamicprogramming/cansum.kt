package com.example.leetcode.dynamicprogramming

// can sum is a function that returns true if the target sum can be generated from the numbers
fun canSum(
    targetSum: Int,
    numbers: IntArray,
    memo: MutableMap<Int, Boolean> = mutableMapOf()
): Boolean {
    if (memo.containsKey(targetSum)) return memo[targetSum]!!
    if (targetSum == 0) return true
    if (targetSum < 0) return false

    for (num in numbers) {
        val remainder = targetSum - num
        if (canSum(remainder, numbers, memo)) {
            memo[targetSum] = true
            return true
        }
    }

    memo[targetSum] = false
    return false
}

// bestsum is a function that returns the shortest
// combination of numbers that add up to the target sum
fun bestSum(
    targetSum: Int,
    numbers: IntArray,
    memo: MutableMap<Int, IntArray?> = mutableMapOf()
): IntArray? {
    if (memo.containsKey(targetSum)) return memo[targetSum]
    if (targetSum == 0) return intArrayOf()
    if (targetSum < 0) return null

    var shortestCombination: IntArray? = null

    for (num in numbers) {
        val remainder = targetSum - num
        val remainderCombination = bestSum(remainder, numbers, memo)

        if (remainderCombination != null) {
            val combination = intArrayOf(*remainderCombination, num)

            if (shortestCombination == null || combination.size < shortestCombination.size) {
                shortestCombination = combination
            }
        }
    }

    memo[targetSum] = shortestCombination
    return shortestCombination
}

// canConstruct is a function that returns true if the target string can be generated from the words
fun canConstruct(
    target: String,
    wordBank: Array<String>,
    memo: MutableMap<String, Boolean> = mutableMapOf()
): Boolean {
    if (memo.containsKey(target)) return memo[target]!!
    if (target.isEmpty()) return true

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.substring(word.length)
            if (canConstruct(
                    target = suffix,
                    wordBank = wordBank,
                    memo = memo
                )
            ) {
                memo[target] = true
                return true
            }
        }
    }

    memo[target] = false
    return false
}

// countConstruct is a function that returns the number of ways the target string can be generated from the words
fun countConstruct(
    target: String,
    wordBank: Array<String>,
    memo: MutableMap<String, Int> = mutableMapOf()
): Int {
    if (memo.containsKey(target)) return memo[target]!!
    if (target.isEmpty()) return 1

    var totalCount = 0

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val numWaysForRest = countConstruct(
                target = target.substring(word.length),
                wordBank = wordBank,
                memo = memo
            )
            totalCount += numWaysForRest
        }
    }

    memo[target] = totalCount
    return totalCount
}

// allConstruct is a function that returns all the ways the target string can be generated from the words
fun allConstruct(
    target: String,
    wordBank: Array<String>,
    memo: MutableMap<String, List<MutableList<String>>> = mutableMapOf()
): List<MutableList<String>> {
    if (memo.containsKey(target)) return memo[target]!!
    if (target.isEmpty()) return listOf(mutableListOf())

    val result = mutableListOf<MutableList<String>>()

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.substring(word.length)
            val suffixWays = allConstruct(
                target = suffix,
                wordBank = wordBank,
                memo = memo
            )
            suffixWays.forEach { it.add(0, word) }
            result.addAll(suffixWays)
        }
    }

    memo[target] = result
    return result
}

// gridtraveler is a function that returns the number of ways to travel from the top-left to the bottom-right of a grid
fun gridtraveler(
    rows: Int,
    cols: Int,
    memo: MutableMap<String, Long> = mutableMapOf()
): Long {
    val key = "$rows,$cols"
    if (memo.containsKey(key)) return memo[key]!!
    if (rows == 0 || cols == 0) return 0
    if (rows == 1 && cols == 1) return 1

    memo[key] = gridtraveler(rows - 1, cols, memo) + gridtraveler(rows, cols - 1, memo)
    return memo[key]!!
}



fun main() {
    println(canSum(7, intArrayOf(2, 3)))  // Output: true
    println(canSum(7, intArrayOf(5, 3, 4, 7)))  // Output: true
    println(canSum(7, intArrayOf(2, 4)))  // Output: false
    println(canSum(8, intArrayOf(2, 3, 5)))  // Output: true
    println(canSum(300, intArrayOf(7, 14)))  // Output: false

}

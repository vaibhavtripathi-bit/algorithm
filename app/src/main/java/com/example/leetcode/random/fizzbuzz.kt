package com.example.leetcode.random


fun fizzBuzz(n: Int): List<String> {
    val result = mutableListOf<String>()
    (1..n).forEach {
        when {
            it % 3 == 0 && it % 5 == 0 -> result.add("FizzBuzz")
            it % 3 == 0 -> result.add("Fizz")
            it % 5 == 0 -> result.add("Buzz")
            else -> result.add(it.toString())
        }
    }

    for (i in 1..n) {
        if (i % 3 == 0 && i % 5 == 0) {
            result.add("FizzBuzz")
        } else if (i % 3 == 0) {
            result.add("Fizz")
        } else if (i % 5 == 0) {
            result.add("Buzz")
        } else {
            result.add(i.toString())
        }
    }
    return result
}

fun main() {
    println(fizzBuzz(15)) // Output: [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
}

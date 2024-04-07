package com.example.leetcode.bitmanipulation

import java.util.SortedMap

class bitmanipulation {
    fun hammingWeight(n: Int): Int {
        var count = 0
        var num = n
        while (num != 0) {
            count += num and 1
            num = num ushr 1
        }
        return count
    }

    fun bitmanipulationInvert() {
        var a = 5
        var b = 7
        println(a xor b)
        a = 1
        b = 0
        println(a xor b)
        a = 1
        b = 1
        println(a xor b)
        a = 1
        b = 7
        println(a xor b)
        a = 5
        b = 7
        println(a xor b)
    }


    fun bitmanipulationSwap() {
        var a = 5
        var b = 7
        a = a xor b
        b = a xor b
        a = a xor b
        println("a: $a, b: $b")
    }

    fun bitmanipulationCheck() {
        val a = 5
        val b = 7
        if (a and b == 0) {
            println("a and b is 0")
        } else {
            println("a and b is not 0")
        }
    }

    fun bitmanipulationSet() {
        val a = 5
        val b = 7
        val c = a or b
        println(c)
    }

    fun bitmanipulationClear() {
        val a = 5
        val b = 7
        val c = a and b.inv()
        println(c)
    }

    fun bitmanipulationUpdate() {
        val a = 5
        val b = 7
        val c = a and b.inv()
        val d = c or 1 shl 2
        println(d)
    }

    fun bitmanipulationinBinary() {
        val num1 = 0b1010 // 10 in binary
        val num2 = 0b1100 // 12 in binary
        // Bitwise AND
        println(num1 and num2) // Output: 8 (0b1000)

        // Bitwise OR
        println(num1 or num2) // Output: 14 (0b1110)

        // Bitwise XOR
        println(num1 xor num2) // Output: 6 (0b0110)

        // Bitwise NOT
        println(num1.inv()) // Output: -11 (in two's complement binary representation)

        // Left Shift
        println(num1 shl 1) // Output: 20 (0b10100)

        // Right Shift
        println(num1 shr 1) // Output: 5 (0b101)

        // Unsigned Right Shift
        println(num1 ushr 1) // Output: 5 (0b101)
    }

    fun bitmanipulationinInteger() {
        fun main() {
            val num1 = 10 // Decimal representation of 10
            val num2 = 12 // Decimal representation of 12

            // Bitwise AND
            println(num1 and num2) // Output: 8

            // Bitwise OR
            println(num1 or num2) // Output: 14

            // Bitwise XOR
            println(num1 xor num2) // Output: 6

            // Bitwise NOT
            println(num1.inv()) // Output: -11

            // Left Shift
            println(num1 shl 1) // Output: 20

            // Right Shift
            println(num1 shr 1) // Output: 5

            // Unsigned Right Shift
            println(num1 ushr 1) // Output: 5
        }
    }

    override fun toString(): String {
        bitmanipulationInvert()
        bitmanipulationSwap()
        bitmanipulationCheck()
        bitmanipulationSet()
        bitmanipulationClear()
        bitmanipulationUpdate()
        bitmanipulationinBinary()
        bitmanipulationinInteger()
        return ""
    }
}

fun main() {
    val bitmanipulation = bitmanipulation()
    println(bitmanipulation)
}


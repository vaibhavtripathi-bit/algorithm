package com.example.leetcode.other

class robotreturntoorigin {
    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        moves.forEach {
            when (it) {
                'U' -> y++
                'D' -> y--
                'L' -> x--
                'R' -> x++
            }
        }
        return x == 0 && y == 0
    }

}

fun main() {
    val robot = robotreturntoorigin()
    println(robot.judgeCircle("UD"))
    println(robot.judgeCircle("LL"))
}

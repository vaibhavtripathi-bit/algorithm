package com.example.leetcode.matrix

// 782. Transform to Chessboard leetcode 782

fun movesToChessboard(board: Array<IntArray>): Int {
    val n = board.size
    val rowSum = IntArray(n)
    val colSum = IntArray(n)
    var rowSwap = 0
    var colSwap = 0

    for (i in board.indices) {
        for (j in board.indices) {
            if (board[0][0] xor board[i][0] xor board[0][j] xor board[i][j] == 1) return -1
        }
    }

    for (i in board.indices) {
        for (j in board.indices) {
            rowSum[i] += board[i][j]
            colSum[i] += board[j][i]
            if (board[i][0] == board[0][0]) {
                if (board[i][j] != board[0][j]) rowSwap++
                if (board[j][i] != board[j][0]) colSwap++
            } else {
                if (board[i][j] == board[0][j]) rowSwap++
                if (board[j][i] == board[j][0]) colSwap++
            }
        }
    }

    if (rowSum[0] != n / 2 && rowSum[0] != (n + 1) / 2) return -1
    if (colSum[0] != n / 2 && colSum[0] != (n + 1) / 2) return -1
    if (n % 2 == 1) {
        if (rowSwap % 2 == 1) rowSwap = n - rowSwap
        if (colSwap % 2 == 1) colSwap = n - colSwap
    } else {
        rowSwap = minOf(rowSwap, n - rowSwap)
        colSwap = minOf(colSwap, n - colSwap)
    }

    return (rowSwap + colSwap) / 2
}

fun main() {
    val board = arrayOf(
        intArrayOf(0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 0, 0, 1),
        intArrayOf(1, 0, 0, 1)
    )
    println(movesToChessboard(board)) // Output: 2
}

// Path: app/src/main/java/com/example/leetcode/matrix/782transformtoChessboard.kt

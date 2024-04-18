

//2326. Spiral Matrix IV

fun spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    var r = r0
    var c = c0
    res.add(intArrayOf(r, c))
    var step = 1
    while (res.size < R * C) {
        for (i in 0 until step) {
            c++
            if (r in 0 until R && c in 0 until C) {
                res.add(intArrayOf(r, c))
            }
        }
        for (i in 0 until step) {
            r++
            if (r in 0 until R && c in 0 until C) {
                res.add(intArrayOf(r, c))
            }
        }
        step++
        for (i in 0 until step) {
            c--
            if (r in 0 until R && c in 0 until C) {
                res.add(intArrayOf(r, c))
            }
        }
        for (i in 0 until step) {
            r--
            if (r in 0 until R && c in 0 until C) {
                res.add(intArrayOf(r, c))
            }
        }
        step++
    }
    return res.toTypedArray()
}

fun main() {
    val result = spiralMatrixIII(5, 6, 1, 4)
    for (i in result) {
        println(i.contentToString())
    }
}
// Output:
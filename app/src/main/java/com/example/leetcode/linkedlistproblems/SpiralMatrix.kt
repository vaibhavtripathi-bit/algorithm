//2326. Spiral Matrix IV

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
    // Convert the linked list to a list
    var node = head
    val list = mutableListOf<Int>()
    while (node != null) {
        list.add(node.`val`)
        node = node.next
    }

    // Initialize the matrix with -1s
    val result = MutableList(m) { IntArray(n) { -1 } }
    var rowStart = 0
    var rowEnd = m - 1
    var colStart = 0
    var colEnd = n - 1
    var index = 0

    while (rowStart <= rowEnd && colStart <= colEnd) {
        // Fill the matrix from left to right
        for (i in colStart..colEnd) {
            if (index < list.size) {
                result[rowStart][i] = list[index++]
            }
        }
        rowStart++

        // Fill the matrix from top to bottom
        for (i in rowStart..rowEnd) {
            if (index < list.size) {
                result[i][colEnd] = list[index++]
            }
        }
        colEnd--

        // Fill the matrix from right to left
        if (rowStart <= rowEnd) {
            for (i in colEnd downTo colStart) {
                if (index < list.size) {
                    result[rowEnd][i] = list[index++]
                }
            }
        }
        rowEnd--

        // Fill the matrix from bottom to top
        if (colStart <= colEnd) {
            for (i in rowEnd downTo rowStart) {
                if (index < list.size) {
                    result[i][colStart] = list[index++]
                }
            }
        }
        colStart++
    }
    return result.toTypedArray()
}



//Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]

fun main() {
    val head = ListNode(3)
    head.next = ListNode(0)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(6)
    head.next?.next?.next?.next = ListNode(8)
    head.next?.next?.next?.next?.next = ListNode(1)
    head.next?.next?.next?.next?.next?.next = ListNode(7)
    head.next?.next?.next?.next?.next?.next?.next = ListNode(9)
    head.next?.next?.next?.next?.next?.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(0)

    val result = spiralMatrix(3, 5, head)
    for (i in result) {
        for (j in i) {
            print("$j ")
        }
        println()
    }
}
// Output:

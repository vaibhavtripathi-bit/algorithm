package com.example.leetcode.leetcode



fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
    if (head?.next == null) {
        return intArrayOf(-1, -1)
    }

    val criticalPoints = findCriticalPoints(head) ?: return intArrayOf(-1, -1)

    val minDistance = findMinDistance(criticalPoints)
    val maxDistance = findMaxDistance(criticalPoints)

    return intArrayOf(minDistance, maxDistance)
}

fun findCriticalPoints(head: ListNode): List<ListNode>? {
    val criticalPoints = mutableListOf<ListNode>()

    var prev: ListNode? = null
    var current: ListNode? = head
    var next: ListNode? = null

    while (current != null) {
        next = current.next

        if (prev != null && next != null) {
            if ((current.`val` < prev.`val` && current.`val` < next.`val`) ||
                (current.`val` > prev.`val` && current.`val` > next.`val`)
            ) {
                criticalPoints.add(current)
            }
        }

        prev = current
        current = next
    }

    return if (criticalPoints.size >= 2) criticalPoints else null
}

fun findMinDistance(criticalPoints: List<ListNode>): Int {
    var minDistance = Int.MAX_VALUE

    for (i in 0 until criticalPoints.size - 1) {
        val distance = distanceBetweenNodes(criticalPoints[i], criticalPoints[i + 1])
        minDistance = minOf(minDistance, distance)
    }

    return minDistance
}

fun findMaxDistance(criticalPoints: List<ListNode>): Int {
    var maxDistance = Int.MIN_VALUE

    for (i in 0 until criticalPoints.size - 1) {
        for (element in criticalPoints) {
            val distance = distanceBetweenNodes(criticalPoints[i], element)
            maxDistance = maxOf(maxDistance, distance)
        }
    }

    return maxDistance
}

fun distanceBetweenNodes(node1: ListNode, node2: ListNode): Int {
    var distance = 0
    var current = node1
    while (current != node2) {
        current = current.next ?: break
        distance++
    }
    return distance
}

class Solution {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        val defaultResult = intArrayOf(-1, -1)
        if (head?.next?.next == null) return defaultResult

        var leftNode: ListNode? = head
        var centerNode: ListNode? = leftNode?.next
        var rightNode: ListNode? = centerNode?.next
        var maxCriticalPoint = -1
        var minCriticalPoint = -1
        var minDistance = Int.MAX_VALUE
        var lastPosition = -1
        var currentPosition = 2

        while (rightNode != null) {
            if ((isLocalMaxima(centerNode, leftNode, rightNode)) || (isLocalMinima(centerNode, leftNode, rightNode))) {
                maxCriticalPoint = currentPosition
                if (minCriticalPoint == -1) minCriticalPoint = currentPosition
                if (lastPosition != -1) {
                    minDistance = minOf(minDistance, currentPosition - lastPosition)
                }
                lastPosition = currentPosition
            }
            leftNode = centerNode
            centerNode = rightNode
            rightNode = rightNode?.next
            currentPosition++
        }

        if (minCriticalPoint == maxCriticalPoint) return defaultResult

        return intArrayOf(minDistance, maxCriticalPoint - minCriticalPoint)
    }

    private fun isLocalMaxima(center: ListNode?, left: ListNode?, right: ListNode?): Boolean {
        return (((center?.`val` ?: Int.MIN_VALUE) > (left?.`val`
            ?: Int.MIN_VALUE) && ((center?.`val` ?: Int.MIN_VALUE) > (right?.`val`
            ?: Int.MIN_VALUE))))
    }

    private fun isLocalMinima(center: ListNode?, left: ListNode?, right: ListNode?): Boolean {
        return (((center?.`val` ?: Int.MAX_VALUE) < (left?.`val`
            ?: Int.MAX_VALUE) && ((center?.`val` ?: Int.MAX_VALUE) < (right?.`val`
            ?: Int.MAX_VALUE))))
    }
}

//    Input: head = [1,3,2,2,3,2,2,2,7]
//    Output: [3,3]

fun main() {
    val head = ListNode(1)
    head.next = ListNode(3)
    head.next?.next = ListNode(2)
    head.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next = ListNode(3)
    head.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next?.next = ListNode(2)
    head.next?.next?.next?.next?.next?.next?.next?.next = ListNode(7)

//    val result = nodesBetweenCriticalPoints(head)
//    println(result.contentToString())

//    [5,3,1,2,5,1,2]
//    Output: [2,3]
    val head2 = ListNode(5)
    head2.next = ListNode(3)
    head2.next?.next = ListNode(1)
    head2.next?.next?.next = ListNode(2)
    head2.next?.next?.next?.next = ListNode(5)
    head2.next?.next?.next?.next?.next = ListNode(1)
    head2.next?.next?.next?.next?.next?.next = ListNode(2)

    val result2 = nodesBetweenCriticalPoints(head2)
    println(result2.contentToString())

}

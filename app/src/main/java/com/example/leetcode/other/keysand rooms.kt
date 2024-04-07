package com.example.leetcode.other

class keysandrooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        dfs(rooms, 0, visited)
        return visited.all { it }
    }

    private fun dfs(rooms: List<List<Int>>, currentRoom: Int, visited: BooleanArray) {
        visited[currentRoom] = true
        rooms[currentRoom].forEach { room: Int ->
            if (!visited[room]) {
                dfs(rooms, room, visited)
            }
        }
    }

    fun canVisitAllRoomsUsingBFS(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        val queue = mutableListOf<Int>()
        queue.add(0)
        visited[0] = true
        while (queue.isNotEmpty()) {
            val currentRoom = queue.removeAt(0)
            rooms[currentRoom].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    queue.add(it)
                }
            }
        }
        return visited.all { it }
    }

    fun canVisitAllRoomsUsingStack(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        val stack = mutableListOf<Int>()
        stack.add(0)
        visited[0] = true
        while (stack.isNotEmpty()) {
            val currentRoom = stack.removeAt(stack.size - 1)
            rooms[currentRoom].forEach {
                if (!visited[it]) {
                    visited[it] = true
                    stack.add(it)
                }
            }
        }
        return visited.all { it }
    }

    // more easy solution
    fun canVisitAllRoomsUsingMap(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf(0)
        val stack = mutableListOf(0)
        while (stack.isNotEmpty()) {
            val currentRoom = stack.removeAt(stack.size - 1)
            rooms[currentRoom].forEach {
                if (it !in visited) {
                    visited.add(it)
                    stack.add(it)
                }
            }
        }
        return visited.size == rooms.size
    }

}

fun main() {
    val keysAndRooms = keysandrooms()
    println(keysAndRooms.canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    println(keysAndRooms.canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
}

class LFUCache3(private val capacity: Int) {
    private data class Node(
        var key: Int,
        var value: Int,
        var freq: Int = 1,
        var prev: Node? = null,
        var next: Node? = null
    )

    private data class DLinkedList(var head: Node = Node(0, 0), var tail: Node = Node(0, 0)) {
        init {
            head.next = tail
            tail.prev = head
        }

        fun remove(node: Node) {
            node.prev?.next = node.next
            node.next?.prev = node.prev
        }

        fun add(node: Node) {
            node.next = head.next
            node.prev = head
            head.next?.prev = node
            head.next = node
        }
    }

    private val nodeMap = mutableMapOf<Int, Node>()
    private val freqMap = mutableMapOf<Int, DLinkedList>()
    private var minFreq = 0
    private var size = 0

    fun get(key: Int): Int {
        val node = nodeMap[key] ?: return -1
        freqMap[node.freq]?.remove(node)
        if (node.freq == minFreq && freqMap[node.freq]?.head?.next == freqMap[node.freq]?.tail) {
            minFreq++
        }
        node.freq++
        freqMap.getOrPut(node.freq) { DLinkedList() }.add(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return
        if (nodeMap.containsKey(key)) {
            nodeMap[key]?.value = value
            get(key)
            return
        }
        if (size == capacity) {
            val node = freqMap[minFreq]?.tail?.prev
            nodeMap.remove(node?.key)
            freqMap[minFreq]?.remove(node!!)
            size--
        }
        val node = Node(key, value)
        nodeMap[key] = node
        freqMap.getOrPut(1) { DLinkedList() }.add(node)
        minFreq = 1
        size++
    }
}

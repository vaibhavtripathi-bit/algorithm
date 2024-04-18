
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
    // Base cases
    if (head == null) return true
    if (root == null) return false

    // Check if the current node matches the start of the linked list
    if (head.`val` == root.`val`) {
        // If the current node matches, check if the remaining nodes of the linked list
        // match the children of the current tree node
        return isSubPathFromCurrentNode(head.next, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
    } else {
        // If the current node doesn't match, recursively check in the left and right subtrees
        return isSubPath(head, root.left) || isSubPath(head, root.right)
    }
}// Complexity O(n*m) and space O(n+m)

fun isSubPathFromCurrentNode(head: ListNode?, root: TreeNode?): Boolean {
    // Base case
    if (head == null) return true
    if (root == null || head.`val` != root.`val`) return false

    // Check if the remaining nodes of the linked list match the left or right subtree of the current node
    return isSubPathFromCurrentNode(head.next, root.left) ||
            isSubPathFromCurrentNode(head.next, root.right)
}


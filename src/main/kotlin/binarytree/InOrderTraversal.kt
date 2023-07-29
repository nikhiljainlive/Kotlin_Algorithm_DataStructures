package binarytree

/**
 *        Binary Tree
 *
 *              4
 *            /   \
 *          5      6
 *        /  \    /  \
 *       7    8  9   10
 * */
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(5)
    root.left?.left = TreeNode(7)
    root.left?.right = TreeNode(8)
    root.right = TreeNode(6)
    root.right?.left = TreeNode(9)
    root.right?.right = TreeNode(10)
    traverseInOrder(node = root, onEach = { println(it.value) })
}

// Left Root Right
private fun traverseInOrder(node: TreeNode?, onEach: (node: TreeNode) -> Unit) {
    if (node == null) {
        return
    }

    traverseInOrder(node.left, onEach)
    onEach(node)
    traverseInOrder(node.right, onEach)
}
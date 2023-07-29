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
    traversePostOrder(node = root, onEach = { println(it.value) })
}

// Left Right Root
private fun traversePostOrder(node: TreeNode?, onEach: (node: TreeNode) -> Unit) {
    if (node == null) {
        return
    }

    traversePostOrder(node.left, onEach)
    traversePostOrder(node.right, onEach)
    onEach(node)
}
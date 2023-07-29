package binarytree

import kotlin.math.max

/**
 *        Binary Tree
 *
 *              1
 *            /   \
 *          2      6
 *        /  \
 *       3    4
 *             \
 *              5
 * */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.left?.right?.right = TreeNode(5)
    root.right = TreeNode(6)
    println(calculateHeightOfBinaryTree(root))
}

private fun calculateHeightOfBinaryTree(node : TreeNode?) : Int {
    if (node == null) {
        return 0
    }

    val left = calculateHeightOfBinaryTree(node.left)
    val right = calculateHeightOfBinaryTree(node.right)
    return max(left, right) + 1
}
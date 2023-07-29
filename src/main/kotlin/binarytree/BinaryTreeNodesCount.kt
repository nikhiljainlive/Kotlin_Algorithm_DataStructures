package binarytree

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
    println(getBinaryTreeNodesCount(root))
}

fun getBinaryTreeNodesCount(node: TreeNode?): Int {
    if (node == null) {
        return 0
    }

    val queue = arrayListOf<TreeNode>()
    queue.add(node)
    var count = 0
    while (queue.isNotEmpty()) {
        val first = queue.firstOrNull() ?: break
        first.left?.let { queue.add(it) }
        first.right?.let { queue.add(it) }
        queue.removeFirst()
        count++
    }
    return count
}
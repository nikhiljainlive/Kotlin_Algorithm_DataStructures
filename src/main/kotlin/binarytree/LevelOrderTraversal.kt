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
    traverseLevelOrder(root)
}

private fun traverseLevelOrder(node: TreeNode?) {
    if (node == null) {
        return
    }

    val list = arrayListOf<TreeNode>()
    list.add(node)
    while (list.isNotEmpty()) {
        val first = list.firstOrNull() ?: break

        if (first.left != null) {
            list.add(first.left!!)
        }
        if (first.right != null) {
            list.add(first.right!!)
        }
        println(first.value)
        list.remove(first)
    }
}
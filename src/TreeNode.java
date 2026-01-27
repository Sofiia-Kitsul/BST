/**
 * TreeNode class representing a single node in the Binary Search Tree.
 * DO NOT MODIFY THIS CLASS.
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor to create a new tree node.
     * @param data The integer value to store in this node
     */
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

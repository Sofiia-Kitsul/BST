import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree implementation in Java.
 *
 * @author Sofiia Kitsul
 * @date January 8th, 2026
 */
public class BinarySearchTree {

    private TreeNode root;

    /**
     * Constructor - initializes an empty BST.
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Insert a value into the BST.
     * If the value already exists, do not insert it (no duplicates allowed).
     *
     * @param value The value to insert
     */
    public void insert(int value) {
        // TODO: Implement this method
        // Hint: Use a recursive helper method
        if(root==null) {
            root = new TreeNode(value);
            return;
        }

        insertHelper(root, value);
    }
    /**
     * Search for a value in the BST.
     *
     * @param value The value to search for
     * @return true if the value exists in the tree, false otherwise
     */
    public boolean search(int value) {
        // TODO: Implement this method
        // Hint: Use recursion and leverage BST property
        boolean verdict = searchHelper(root, value);
        return verdict;
    }


    /**
     * Delete a value from the BST.
     * If the value doesn't exist, do nothing.
     *
     * @param value The value to delete
     */
    public void delete(int value) {
        // TODO: Implement this method
        // Hint: Handle three cases - leaf, one child, two children
        // For two children, use inorder successor or predecessor
        root = deleteHelper(root, value);
    }



    /**
     * Find the minimum value in the BST.
     *
     * @return The minimum value
     * @throws IllegalStateException if the tree is empty
     */
    public int findMin() {
        // TODO: Implement this method
        // Hint: Keep going left!
        if(root == null){
            throw new IllegalStateException("Tree is empty");
        }
        TreeNode n = root;
        while(n.getLeft() != null){
            n = n.getLeft();
        }
        return n.getData();
    }

    /**
     * Find the maximum value in the BST.
     *
     * @return The maximum value
     * @throws IllegalStateException if the tree is empty
     */
    public int findMax() {
        // TODO: Implement this method
        // Hint: Keep going right!
        if(root == null){
            throw new IllegalStateException("Tree is empty");
        }
        TreeNode n = root;
        while(n.getRight() != null){
            n = n.getRight();
        }
        return n.getData();
    }//difference between lists!
    /**
     *
     * */
    /**
     * Perform an inorder traversal of the BST.
     *
     * @return A list of values in inorder sequence
     */
    public List inorderTraversal() {
        //lcr
        // TODO: Implement this method
        // Hint: Left -> Root -> Right
        // Should return values in sorted order!
        ArrayList<Integer> myList = new ArrayList<>();
        return inorderTraversalHelper(root, myList);
    }



    /**
     * Perform a preorder traversal of the BST.
     *
     * @return A list of values in preorder sequence
     */
    public List preorderTraversal() {
        //clr
        // TODO: Implement this method
        // Hint: Root -> Left -> Right
        ArrayList<Integer> myList = new ArrayList<>();
        return preorderTraversalHelper(root, myList);
    }


    /**
     * Perform a postorder traversal of the BST.
     *
     * @return A list of values in postorder sequence
     */
    public List postorderTraversal() {
        //lrc
        // TODO: Implement this method
        // Hint: Left -> Right -> Root
        ArrayList<Integer> myList = new ArrayList<>();
        return postorderTraversalHelper(root, myList);
    }

    /**
     * Calculate the height of the BST.
     * Height is defined as the number of edges on the longest path from root to leaf.
     * An empty tree has height -1, a tree with one node has height 0.
     *
     * @return The height of the tree
     */
    public int height() {
        // TODO: Implement this method
        // Hint: Use recursion - height = 1 + max(left height, right height)
        if(root == null){
            return -1;
        }
        return heightHelper(0, root);
    }


    /**
     * Count the number of nodes in the BST.
     *
     * @return The number of nodes
     */
    public int size() {
        // TODO: Implement this method
        // Hint: Recursively count nodes
        // exeption if root is null!!!!!
        return sizeHelper(root);
    }

    /**
     * Check if the BST is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    //USE THSI PLEASE IN OTHERS
    public boolean isEmpty() {
        // TODO: Implement this method
        if (root == null){
            return true;
        }
        return false;
    }

    /**
     * Get the root of the tree (for testing purposes).
     *
     * @return The root node
     */
    public TreeNode getRoot() {
        return this.root;
    }

    // ========================================
    // HELPER METHODS
    // You may add private helper methods below
    // ========================================

    public void insertHelper(TreeNode n, int value) {
        System.out.println("I'm adding");
        if(n != null) {
            if (n.getData() == value) {
                // exit!??
                return;
            }
            else if (n.getData() > value) {
                System.out.println("I'm gonna go left");
                if(n.getLeft() == null){
                    TreeNode newN = new TreeNode(value);
                    n.setLeft(newN);
                }
                n = n.getLeft();
            }
            else if (n.getData() < value) {
                System.out.println("I'm gonna go right");
                if(n.getRight() == null){
                    TreeNode newN = new TreeNode(value);
                    n.setRight(newN);
                }
                n = n.getRight();
            }
            insertHelper(n, value);
        }
    }
    public boolean searchHelper(TreeNode n, int value) {
        boolean searchResult = false;
        if(n != null){
            System.out.println("I'm checking: " + n.getData());
            if(n.getData() == value){
                System.out.println("true!");
                searchResult = true;
                return true;
            }
            else if(n.getData() > value){
                System.out.println("I'm gonna go left");
                n = n.getLeft();
            }
            else if(n.getData() < value){
                System.out.println("I'm gonna go right");
                n = n.getRight();
            }
            searchResult = searchHelper(n, value);
        }
        return searchResult;
    }
    public TreeNode deleteHelper( TreeNode n, int value) {
        System.out.println("I'm on node: " + n.data);
        if(n == null) {
            return null;
        }
        if(n.getData() > value){
            n.setLeft(deleteHelper(n.getLeft(), value));
        }
        else if(n.getData() < value){
            n.setRight(deleteHelper(n.getRight(), value));
        }
        else {
            if (n.getLeft() == null && n.getRight() == null) {
                return null;
            }
            if(n.getLeft() == null){
                return n.getRight();
            }
            if(n.getRight() == null){
                return n.getLeft();
            }
            TreeNode newN = findMinDeleteHelper(n.getRight());
            n.setData(newN.getData());
            n.setRight(deleteHelper(n.getRight(), newN.getData()));
        }
        return n;
    }
    public TreeNode findMinDeleteHelper(TreeNode n) {
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }
    private List<Integer> inorderTraversalHelper(TreeNode n, ArrayList<Integer> myList) {
        if (n == null) {
            return myList;
        }

        inorderTraversalHelper(n.getLeft(), myList);
        myList.add(n.getData());
        inorderTraversalHelper(n.getRight(), myList);

        return myList;
    }

    private List<Integer> preorderTraversalHelper(TreeNode n, ArrayList<Integer> myList) {
        if (n == null) {
            return myList;
        }

        myList.add(n.getData());
        preorderTraversalHelper(n.getLeft(), myList);
        preorderTraversalHelper(n.getRight(), myList);

        return myList;
    }
    private List<Integer> postorderTraversalHelper(TreeNode n, ArrayList<Integer> myList) {
        if (n == null) {
            return myList;
        }

        postorderTraversalHelper(n.getLeft(), myList);
        postorderTraversalHelper(n.getRight(), myList);
        myList.add(n.getData());

        return myList;
    }
    public int heightHelper(int maxHeight, TreeNode n) {
        if(n == null) {
            return -1;
        }
        int leftHeight = heightHelper(0, n.getLeft());
        int rightHeight = heightHelper(0, n.getRight());
        if(leftHeight > rightHeight){
            maxHeight = leftHeight;
        }
        else {
            maxHeight = rightHeight;
        }
        return maxHeight + 1;
    }
    public int sizeHelper(TreeNode n){
        if(n == null) {
            return 0;
        }
        else {
            return 1 + sizeHelper(n.getLeft()) + sizeHelper(n.getRight());
        }
    }

}

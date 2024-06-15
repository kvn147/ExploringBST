

/**
 * This class represents a binary search tree where duplicate data values are allowed in the tree nodes
 *
 * @param <E> data type stored in the tree nodes (E must implement the Comparable interface)
 */
public class BST<E extends Comparable<E>> {
    private TreeNode<E> overallRoot;

    public BST() {
        overallRoot = null;
    }


    /**
     * Adds a new TreeNode to the binary search tree (BST)
	 * maintaining binary search tree order
     *
     * @param value data value added to BST
     */
    public void add(E value) {
          overallRoot = add(overallRoot, value);
    }

	// recursive helper method for add
    private TreeNode<E> add(TreeNode<E> root, E value) {
		// base case
        if (root == null) {
            return new TreeNode<>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }

        return root;
    }

    /**
     * Determines if the searchValue is in the BST
     *
     * @param searchValue value to find in BST
     * @return true if searchValue is in BST, false otherwise
     */
    public boolean contains(E searchValue) {
        return contains(overallRoot, searchValue);
    }

	// recursive helper method for contains
    private boolean contains(TreeNode<E> root, E searchValue) {
        // base case 1
        if (root == null) {
            return false;
        } else if (root.data.compareTo(searchValue) == 0) { // base case 2
            return true;
        } else if (root.data.compareTo(searchValue) > 0) { // searchValue < root.data, look left for searchValue
            return contains(root.left, searchValue);
        } else { // searchValue > root.data, look right for searchValue
            return contains(root.right, searchValue);
        }
    }


    /**
     * Finds the largest value in the tree
     *
     * @return the largest value
     */
    public E max() {
        // return the value of the greatest node in the BST by calling the helper method
        return findMax(overallRoot);
    }

    // recursive helper method for findMax
    private E findMax(TreeNode<E> root) {
        // base case if there are no greater nodes than the root
        if (root.right == null) {
            return root.data;
        }
        // continue to traverse right where the node value is greatest
        else {
            return findMax(root.right);
        }
    }


    /**
     * prints the data of the tree in sorted order
     */
    public void print() {
        System.out.print("In order = ");
        printInorder(overallRoot);
        System.out.println();
    }

    // recursive helper method for printInorder
    private void printInorder(TreeNode<E> root) {
        // base case
        if (root == null) {
            return;
        } else {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }


    /**
     * Determines if the Binary Tree is a Binary Search Tree where lower values are on the left and
     * higher values are on the right
     *
     * @return true,if tree is a valid binary search tree, false otherwise
     */
    public boolean isBST() {
        return isBST(overallRoot);
    }

    // recursive helper method for isBST
    private boolean isBST(TreeNode<E> root) {
        // base case
        if (root == null) {
            return true;
        } else {
            boolean leftCheck;
            // check if root.left exists before trying to compare root.data to root.left.data
            if (root.left == null) {
                // set leftCheck to true since no possibility BST structure is compromised
                leftCheck = true;
            } else {
                // check if root.data is greater than or equal to root.left.data
                leftCheck = root.data.compareTo(root.left.data) >= 0;
            }

            boolean rightCheck;
            // check if root.right exists before trying to compare root.data to root.right.data
            if (root.right == null) {
                // set rightCheck to true since no possibility BST structure is compromised
                rightCheck = true;
            } else {
                // check if root.data is less than root.right.data
                rightCheck = root.data.compareTo(root.right.data) < 0;
            }
            // ultimately will return true if BST structure is satisfied
            return leftCheck && rightCheck && isBST(root.left) && isBST(root.right);
        }
    }

    /**
     * Determines if the tree is full meaning each node in the tree has 0 or 2 children
     *
     * @return true if tree is full, false otherwise
     */
    public boolean isFull() {
        return isFull(overallRoot);
    }

    // recursive helper method
    private boolean isFull(TreeNode<E> root) {
        if (root == null) {
            return true;
        }
        else if (root.left == null && root.right == null) { // have 0 children
            return true;
        }
        else if (root.left == null || root.right == null) {
            return false;
        }
        else {
                return isFull(root.left) && isFull(root.right);
        }
    }


}
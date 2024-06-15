/**
 * Class for storing a single node of a binary tree
 * @param <E> data type for node's data field (Integer, String, etc)
 */
public class TreeNode<E> {
    public E data;
    public TreeNode<E> left;
    public TreeNode<E> right;

    /**
     * Constructs a leaf node
     * @param data data stored in node
     */
    public TreeNode(E data) {
        this(data, null, null);
    }

    /**
     * Constructs  a branch node
     * @param data data stored in node
     * @param left left subtree
     * @param right right subtree
     */
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
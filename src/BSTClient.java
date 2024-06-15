/**
 * This class uses an array of integers to construct a Binary Search Tree where the first element
 * in the array is the overall root of the BST and then the remaining array numbers are placed in the left
 * subtree if they are less than or equal to the overall root and placed in the right subtree if they are
 * greater than the overall root of the BST according the binary search tree add algorithm.
 *
 */
public class BSTClient {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 7, 8};
        int[] numbers2 = {7, 4, 2, 3, 8, 9};
        int[] numbers3 = {5, 4, 7, 3, 9, 6};
        // TODO create a numbers4 array that will result in a full BST with 4 levels
        int[] numbers4 = {50, 20, 70, 16, 32, 60, 90, 15, 19, 24, 33, 56, 67 ,72, 100};

        BST<Integer> bst = new BST<>();
        for(int n : numbers4)
            bst.add(n);

        System.out.println("==== Tree Info ==== ");
        bst.print();
        System.out.println("The largest value in the tree is " + bst.max() + ".");
        System.out.println("isFull? " + bst.isFull()); // full tree has 0 or 2 children
        System.out.println("isBST? " + bst.isBST());
        System.out.println("contains 3? " + bst.contains(3));

    }

}

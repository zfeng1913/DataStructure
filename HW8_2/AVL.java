import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 */
public class AVL<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private AVLNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the tree.
     *
     * Start by adding it as a leaf like in a regular BST and then rotate the
     * tree as necessary.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after adding the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    private AVLNode<T> radd(AVLNode<T>curr, T data){
      if (data == null){
        throw new IllegalArgumentException();
      }
      if (curr == null){
        size ++;
        return new AVLNode<T>(data);
      }else if (data.compareTo(curr.getData()) < 0){
        curr.setLeft(radd(curr.getLeft(), data));
      }else if (data.compareTo(curr.getData()) > 0){
        curr.setRight(radd(curr.getRight(), data));
      }
      return balance(curr);
    }
    public void add(T data) {
      root = radd(root, data);
    }

    /**
     * Removes and returns the element from the tree matching the given
     * parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     *    simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     *    replace it with its child.
     * 3: The node containing the data has 2 children. Use the successor to
     *    replace the data, NOT predecessor. As a reminder, rotations can occur
     *    after removing the successor node.
     *
     * Remember to recalculate heights and balance factors while going back
     * up the tree after removing the element, making sure to rebalance if
     * necessary. This is as simple as calling the balance() method on the
     * current node, before returning it (assuming that your balance method
     * is written correctly from part 1 of this assignment).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If the data is null.
     * @throws java.util.NoSuchElementException   If the data is not found.
     */
     private AVLNode<T> removeSuccessor(AVLNode<T> curr, AVLNode<T> dummy){
       if (curr.getLeft() == null){
         dummy.setData(curr.getData());
         return curr.getRight();
       } else{
         curr.setLeft(removeSuccessor(curr.getLeft(), dummy));
         return curr;
       }
     }
     private AVLNode<T> rRemove(AVLNode<T> curr, T data, AVLNode<T> remove){
       if (curr == null){
         throw new NoSuchElementException();
       }else if (data.compareTo(curr.getData()) < 0){
         curr.setLeft(rRemove(curr.getLeft(), data, remove));
       }else if (data.compareTo(curr.getData()) >0){
         curr.setRight(rRemove(curr.getRight(), data, remove));
       }else{
         size --;
         remove.setData(curr.getData());
         if (curr.getLeft() == null & curr.getRight() == null){
           return null;
         }else if (curr.getLeft() == null){
           return curr.getRight();
         }else if (curr.getRight() == null){
           return curr.getLeft();
         }else{
           AVLNode<T> dummy2 = new AVLNode<>(null);
           curr.setRight(removeSuccessor(curr.getRight(), dummy2));
           curr.setData(dummy2.getData());
         }
       }
       return balance(curr);
     }
    public T remove(T data) {
      if (data == null){
        throw new IllegalArgumentException();
      }
      AVLNode<T> remove = new AVLNode<>(null);
      root = rRemove(root, data, remove);
      return remove.getData();
    }

    /**
     * Updates the height and balance factor of a node using its
     * setter methods.
     *
     * Recall that a null node has a height of -1. If a node is not
     * null, then the height of that node will be its height instance
     * data. The height of a node is the max of its left child's height
     * and right child's height, plus one.
     *
     * The balance factor of a node is the height of its left child
     * minus the height of its right child.
     *
     * This method should run in O(1).
     * You may assume that the passed in node is not null.
     *
     * This method should only be called in rotateLeft(), rotateRight(),
     * and balance().
     *
     * @param currentNode The node to update the height and balance factor of.
     */
    private void updateHeightAndBF(AVLNode<T> node) {
        int left_height;
        int right_height;
        if (node.getLeft() == null){
            left_height = -1;
        }else{
            left_height = node.getLeft().getHeight();
        }
        if (node.getRight() == null){
            right_height = -1;
        }else{
            right_height = node.getRight().getHeight();
        }
        node.setHeight(Math.max(right_height, left_height) + 1);
        node.setBalanceFactor(left_height - right_height);}


    /**
     * Method that rotates a current node to the left. After saving the
     * current's right node to a variable, the right node's left subtree will
     * become the current node's right subtree. The current node will become
     * the right node's left subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is right heavy. Therefore, you do not need to
     * perform any preliminary checks, rather, you can immediately perform a
     * left rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
        AVLNode<T> node_b = currentNode.getRight();
        currentNode.setRight(node_b.getLeft());
        node_b.setLeft(currentNode);
        return node_b;
    }

    /**
     * Method that rotates a current node to the right. After saving the
     * current's left node to a variable, the left node's right subtree will
     * become the current node's left subtree. The current node will become
     * the left node's right subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is left heavy. Therefore, you do not need to perform
     * any preliminary checks, rather, you can immediately perform a right
     * rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    private AVLNode<T> rotateRight(AVLNode<T> currentNode) {
        AVLNode<T> node_b = currentNode.getLeft();
        currentNode.setLeft(node_b.getRight());
        node_b.setRight(currentNode);
        return node_b;
    }

    /**
     * Method that balances out the tree starting at the node passed in.
     * This method should be called in your add() and remove() methods to
     * facilitate rebalancing your tree after an operation.
     *
     * The height and balance factor of the current node is first recalculated.
     * Based on the balance factor, a no rotation, a single rotation, or a
     * double rotation takes place. The current node is returned.
     *
     * You may assume that the passed in node is not null. Therefore, you do
     * not need to perform any preliminary checks, rather, you can immediately
     * check to see if any rotations need to be performed.
     *
     * This method should run in O(1).
     *
     * @param currentNode The current node under inspection.
     * @return The AVLNode that the caller should return.
     */
    private AVLNode<T> balance(AVLNode<T> currentNode) {
        updateHeightAndBF(currentNode);
        if (currentNode.getBalanceFactor()==-2) {
            if (currentNode.getRight().getBalanceFactor()>0) {
                currentNode.setRight(rotateRight(currentNode.getRight()));
            }
            currentNode = rotateLeft(currentNode);
        } else if (currentNode.getBalanceFactor()==2) {
            if (currentNode.getLeft().getBalanceFactor()<0) {
                currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            }
            currentNode = rotateRight(currentNode);
        }
        return currentNode;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree.
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

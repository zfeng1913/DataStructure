import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */
    private boolean contains_helper(BSTNode<T> cur, T data){
      if (cur == null){
        return false;
      }
      if (cur.getData().equals(data)){
        return true;
      }else if (data.compareTo(cur.getData()) < 0){
        return contains_helper(cur.getLeft(), data);
      }else{
        return contains_helper(cur.getRight(), data);
      }
    }
    public boolean contains(T data) {
      return contains_helper(root, data, answer);
         // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }
    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    private BSTNode<T> radd(BSTNode<T> curr, T data){
      if (data == null){
        throw new IllegalArgumentException();
      }
      if (curr == null){
        size ++;
        return new BSTNode<T>(data);
      }else if (data.compareTo(curr.getData()) < 0){
        curr.setLeft(radd(curr.getLeft(), data));
      }else if (data.compareTo(curr.getData()) > 0){
        curr.setRight(radd(curr.getRight(), data));
      }
      return curr;
    }
    public void add(T data) {
      root = radd(root, data);
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
     private BSTNode<T> removeSuccessor(BSTNode<T> curr, BSTNode<T> dummy){
       if (curr.getLeft() == null){
         dummy.setData(curr.getData());

         return curr.getRight();
       } else{
         curr.setLeft(removeSuccessor(curr.getLeft(), dummy));
         return curr;
       }
     }
     private BSTNode<T> rRemove(BSTNode<T> curr, T data, BSTNode<T> remove){
       if (data == null){
             throw new IllegalArgumentException();
         }
       if (curr == null){
         throw new NoSuchElementException();
       }else if (data.compareTo(curr.getData()) < 0){
         curr.setLeft(rRemove(curr.getLeft(), data, remove));
       }else if (data.compareTo(curr.getData()) >0){
         curr.setRight(rRemove(curr.getRight(), data, remove));
       }else{
         remove.setData(curr.getData());
         size --;
         if (curr.getLeft() == null & curr.getRight() == null){
           return null;
         }else if (curr.getLeft() == null){
           return curr.getRight();
         }else if (curr.getRight() == null){
           return curr.getLeft();
         }else{
           BSTNode<T> dummy2 = new BSTNode<>(null);
           curr.setRight(removeSuccessor(curr.getRight(), dummy2));
           curr.setData(dummy2.getData());
         }
       }
       return curr;
     }
     public T remove(T data) {
         BSTNode<T> remove = new BSTNode<>(null);
         root = rRemove(root, data, remove);
         return remove.getData();
     }


    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

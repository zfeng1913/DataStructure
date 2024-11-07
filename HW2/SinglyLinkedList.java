import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null){
        throw new IllegalArgumentException();
      }

        SinglyLinkedListNode<T> new_node = new SinglyLinkedListNode<>(data);
        new_node.setNext(head);
        head = new_node;
        if (size == 0){
          tail = new_node;
        }
        size++;

        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
        throw new IllegalArgumentException();
      }
        if (head == null){
            head = new SinglyLinkedListNode<>(data);
            size++;}
        else{
            SinglyLinkedListNode<T> cur = head;
            while (cur.getNext()!=null){
                cur = cur.getNext();
            }
            cur.setNext(new SinglyLinkedListNode<T>(data));
            tail = cur.getNext();
            size++;
        }


    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        if (head == null){
            throw new NoSuchElementException();}
        T ans = head.getData();
        head = head.getNext();
        size--;
        return ans;
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        if (head == null){
        throw new NoSuchElementException();}
        else if (size == 1){
            T ans = head.getData();
            head = null;
            size --;
            return ans;
        }else{
            SinglyLinkedListNode<T> cur = head;
            while (cur.getNext().getNext()!=null){
                cur = cur.getNext();}
            tail = cur;
            T ans = cur.getNext().getData();

            cur.setNext(null);
            size --;
            return ans;

        }

    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

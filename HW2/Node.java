/**
 * Node class used for implementing the SinglyLinkedList.
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class Node<T> {

    private T element;
    private Node<T> nextNode;
    private Node<T> previousNode;

    /**
     * Constructs a new SinglyLinkedListNode with the given data and next node
     * reference.
     *
     * @param data the data stored in the new node
     * @param next the next node in the list
     */
    Node(T element, Node<T> previousNode, Node<T> nextNode) {
        this.element = element;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    /**
     * Creates a new SinglyLinkedListNode with only the given data.
     *
     * @param data the data stored in the new node
     */
    Node(T element) {
        this(element, null);
    }
    Node() {
        this(element, null, null);
    }

    T getElement() {
        return element;
    }


}

/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package structures;

import exceptions.EmptyCollectionException;

/**
 * A singly-linked implementation of the QueueADT.
 * 
 * @author Alan Fowler - An adaptation of code from several textbooks
 * @version 1.1
 *
 * @param <E>
 */
public class LinkedQueue<E> implements QueueADT<E> {
    
    /** The error message of EmptyCollectionException. */
    private static final String ERROR = "Empty Queue";
    
    /**
     * The number of elements contained in the queue.
     */
    protected int mySize;
    
    /**
     * A reference to the first node in the queue.
     * (The 'head' of the queue.)
     */
    protected Node<E> myFront;
    
    /**
     * A reference to the last node in the queue.
     * (The 'tail' of the queue.)
     */
    protected Node<E> myRear;
    
    /**
     * Initialize an empty queue.
     */
    public LinkedQueue() {
        mySize = 0;
        myFront = null;
        myRear = null;
    }
    
    @Override
    public void enqueue(final E theElement) {
        if (mySize == 0) { // Make a queue of one element
            myFront = new Node<E>(theElement);
            myRear = myFront;
        } else { // Regular case
            myRear.myNext = new Node<E>(theElement);
            myRear = myRear.myNext;
        }
        mySize++;
    }

    @Override
    public E dequeue() {
        if (mySize == 0) {
            throw new EmptyCollectionException(ERROR);
        }

        final E returnValue = myFront.myData;
        myFront = myFront.myNext;
        mySize--;
        return returnValue;
    }


    @Override
    public E first() {
        if (mySize == 0) {
            throw new EmptyCollectionException(ERROR);
        }
        return myFront.myData;
    }

    @Override
    public int size() {
        return mySize;
    }
    
    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }
    
    /**
     * The returned String lists each element in the queue and includes a label for
     * the front of the queue.
     * 
     * <p>The format of the returned String is:
     * Front -> 8, 6, 7, 5, 3, 0, 9
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (mySize > 0) {
            sb.append("front -> ");
            Node<E> temp = myFront;
            for (int i = 0; i < mySize - 1; i++) {
                sb.append(temp.myData);
                sb.append(", ");
                temp = temp.myNext;
            }
            sb.append(temp.myData);
        }
        return sb.toString();
    }
    
    // Inner Node class

    /**
     * Represents a node in a singly linked structure.
     * 
     * @author Alan Fowler - An adaptation of code from several textbooks
     * @version 1.1
     *
     * @param <T>
     */
    public class Node<T> {

        /**
         * A reference to the next node in the liked structure.
         */
        private Node<T> myNext;
        
        /**
         * A reference to the data element held in this node.
         */
        private T myData;
        
        /**
         * Initialize the node using the specified data element.
         * 
         * @param theData the data element held in this node
         */
        Node(final T theData) {
            this(theData, null);
        }
        
        /**
         * Initialize the node using the specified data element and
         * the specified next node.
         * 
         * @param theData the data element held in this node
         * @param theNext the next node in the linked structure
         */
        Node(final T theData, final Node<T> theNext) {
            myData = theData;
            myNext = theNext;
        }
    }

}

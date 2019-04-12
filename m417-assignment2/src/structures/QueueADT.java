/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package structures;

/**
 * Defines operations for a FIFO queue.
 * 
 * @author Alan Fowler - An adaptation of code from several textbooks
 * @version 1.1
 * 
 * @param <E>
 */
public interface QueueADT<E> {
    
    /**
     * Adds the specified element to the 'rear' or 'tail' of the queue.
     * 
     * @param theElement the element to add to the queue
     */
    void enqueue(E theElement);

    /**
     * Removes and returns the 'front' or 'head' element from the queue.
     * (Remove and return the least recently added element from the queue.)
     * 
     * @throws EmptyCollectionException if the queue is empty.
     * @return the front element from the queue
     */
    E dequeue();

    /**
     * Returns the 'front' or 'head' element from the queue (without removing
     * the element).
     * 
     * @throws EmptyCollectionException if the queue is empty.
     * @return the front element from the queue
     */
    E first();

    /**
     * How many elements are in the queue?
     * 
     * @return the count of elements currently in the queue
     */
    int size();
    
    /**
     * Is the queue empty?
     * 
     * @return True if the queue contains no elements; False otherwise
     */
    boolean isEmpty();

}

/*
 * TCSS 342
 */

package structures;

/**
 * Defines operations for a LIFO stack.
 *
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 *
 * @param <E>
 */
public interface StackADT<E>
{

    /**
     * Adds the specified element to the top of the stack.
     *
     * @param theElement the element to add to the stack
     */
    void push(E theElement);

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element in the stack
     * @throws EmptyStackException if the stack is empty
     */
    E pop();

    /**
     * Returns the top element from the stack (without removing the element).
     *
     * @return the top element in the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek();

    /**
     * How many elements are in the stack?
     *
     * @return the count of elements currently in the stack
     */
    int size();

    /**
     * Is the stack empty?
     *
     * @return True if the stack contains no elements; False otherwise
     */
    boolean isEmpty();

}

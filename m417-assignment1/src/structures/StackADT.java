
package structures;

import exceptions.EmptyCollectionException;

/**
 * Defines the interface to a stack collection.
 *
 * @author Lewis and Chase
 * @author Alan Fowler - formatted for TCSS 342; added comments
 * @version 1.1
 * 
 * @param <T> the generic data type
 */
public interface StackADT<T> {
    /**
     * Adds the specified element to the top of this stack.
     * 
     * @param theElement element to be pushed onto the stack
     */
    void push(T theElement);
    
    /*
     * pop() is often implemented as both a query and a command.
     *  
     * Maybe we should implement
     *    'remove()' and 'peek()'?
     * or 'top()'    and 'pop()'?
     * or 'peekTop()'  and 'removeTop()'?
     */
    
    /*
     * Ideally exceptions should be specified in the interface
     * (for consistency across implementations)
     * 
     *  pop() and peek() on an empty stack will result in an exception in this design
     *  
     *  An alternative solution would be to return null
     *  (This works only if the collection is not allowed to contain null elements)
     */

    /**
     * Removes and returns the top element from this stack.
     * 
     * @return the element removed from the stack
     * @throws EmptyCollectionException if the stack is empty
     */
    T pop();

    /**
     * Returns without removing the top element of this stack.
     * 
     * @return the element on top of the stack
     * @throws EmptyCollectionException if the stack is empty
     */
    T peek();

    /**
     * Is the stack empty?
     * 
     * @return True if the stack contains no elements; False otherwise
     */
    boolean isEmpty();

    /**
     * How many elements are in the stack?
     * 
     * @return the count of elements currently in the stack
     */
    int size();
}

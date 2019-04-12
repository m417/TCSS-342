
package structures;

import exceptions.EmptyCollectionException;
import java.util.Arrays;

/**
 * An array based implementation of a LIFO stack in which the bottom of the stack is fixed
 * at index 0.
 * 
 * This Stack implementation allows null elements.
 * 
 * @author Lewis and Chase
 * @author Alan Fowler - formatted for TCSS 342; added comments
 * @version 1.1
 * 
 * @param <T> the generic data type
 */
public class ArrayStack<T> implements StackADT<T> {
    
    /**  The default capacity for a Stack. */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The number of elements currently in the Stack.
     */
    private int mySize;
    // the number of elements in the Stack, not the capacity of the array
    // This also indicates the array index where push would add an element.
    
    /**
     * The backing store for the elements in the Stack.
     */
    private T[] myElements;

    /**
     * Creates an empty stack using the DEFAULT_CAPACITY.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    // This optional constructor exposes the fact that this is an array based implementation.
    /**
     * Creates an empty stack using the specified capacity.
     * If the specified capacity is less than DEFAULT_CAPACITY,
     * then the DEFAULT_CAPACITY is used instead.
     * 
     * @param theInitialCapacity the initial size of the backing store array
     */
    public ArrayStack(final int theInitialCapacity) {
        mySize = 0;
        
        
        /* The code below will not compile because we cannot
           instantiate a new generic array of T. */
        //myElements = new T[theInitialCapacity];
        
        // the cast produces a warning but is necessary
        // avoid a negative or zero array size
        // (Do not allow a capacity smaller than DEFAULT_CAPACITY)
        myElements = (T[]) (new Object[Math.max(DEFAULT_CAPACITY, theInitialCapacity)]);
        
    }
    
    
    
    
    
    /*
     * Javadoc is automatically inherited from the parent for overridden methods.
     * If you want to add something to the inherited javadoc, then write a new javadoc comment
     * here and place the {@inheritDoc} inline javadoc comment in your comment at the point
     * where you want the inherited javadoc comments to appear.  
     */
    

    @Override
    public void push(final T theElement) {
        if (size() == myElements.length) {
            expandCapacity();
        }
        
        /* Many software engineers recommend against embedding an increment
         * in a larger statement as done here. Instead the recommendation is
         * to improve the clarity of the code by doing this in two statements as shown below.
         */
        //myElements[mySize++] = theElement;

        myElements[mySize] = theElement;
        mySize++;
    }

    /**
     * Creates a new array to store the contents of this stack with twice the
     * capacity of the old one.
     */
    private void expandCapacity() {
        myElements = Arrays.copyOf(myElements, myElements.length * 2);
    }


    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        
        // pre-decrement in a larger statement can be efficient but unclear
        //return (T) myElements[--mySize];
        
        // the general recommendation is to use the following design instead:
        
        mySize--;
        final T result = myElements[mySize];
        
        /*
         * Set the reference to the element to null so that the memory can be reclaimed
         * by the garbage collector (to avoid a 'memory leak').
         * Setting the reference to null will produce a warning from PMD,
         * but we are doing this for a valid reason.
         */
        myElements[mySize] = null;

        return result;
    }


    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return myElements[mySize - 1];
    }


    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }


    @Override
    public int size() {
        return mySize;   // number of elements in the Stack, not the capacity of the array
    }

    /**
     * Returns a string representation of this stack.
     * 
     * @return a string representation of the stack
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("Empty Stack"); // maybe an empty stack should return an empty String?
        } else {
            for (int index = mySize - 1; index >= 0; index--) {
                sb.append(myElements[index]);
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}

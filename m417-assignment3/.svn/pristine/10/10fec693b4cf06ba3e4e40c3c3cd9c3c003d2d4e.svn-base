/*
 * TCSS 342
 */

package structures;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A dynamic array-based LIFO stack.
 *
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 *
 * @param <E>
 */
public class ArrayStack<E> implements StackADT<E>
{

    /**
     * The default initial size for a new stack.
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * The backing store for this collection.
     */
    private E[] myElements;

    /**
     * The number of elements currently in the stack.
     */
    private int mySize;  // mySize also indicates the next available (open) array index

    /**
     * Initializes the stack.
     * Initializes the backing array to a default size.
     */
    public ArrayStack()
    {

        /*
         * The warning here about type safety can be ignored.
         * It is not possible to instantiate a generic array, so this is the
         * standard work around.
         */
        myElements = (E[]) new Object[DEFAULT_SIZE];

        mySize = 0;
    }

    /**
     * Initializes the stack.
     * Initializes the backing array to the specified size.
     *
     * @param theInitialCapacity the initial size to assign to the backing array
     */
    public ArrayStack(final int theInitialCapacity)
    {
        // do not allow a negative array size
        myElements = (E[]) new Object[Math.max(0, theInitialCapacity)];

        mySize = 0;
    }

    @Override
    public void push(final E theElement)
    {
        if (mySize == myElements.length)
        {
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

    @Override
    public E pop()
    {
        if (mySize == 0)
        {
            throw new EmptyStackException();
        }

        // pre-decrement in a larger statement can be unclear
        //return (E) myElements[--myCount];

        // the above has a memory leak - below is the fix

        final E elementToReturn = myElements[mySize - 1];
        mySize--;
        myElements[mySize] = null; // intentional null assignment - OK to ignore the warning

        return elementToReturn;
    }

    @Override
    public E peek()
    {
        if (mySize == 0)
        {
            throw new EmptyStackException();
        }
        return (E) myElements[mySize - 1];
    }

    @Override
    public int size()
    {
        return mySize;
    }

    @Override
    public boolean isEmpty()
    {
        return mySize == 0;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        if (isEmpty())
        {
            sb.append("Empty Stack"); // maybe an empty stack should return an empty String?
        }
        else
        {
            for (int index = mySize - 1; index >= 0; index--)
            {
                sb.append(myElements[index]);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    /**
     * Doubles the capacity of the backing store.
     */
    private void expandCapacity()
    {
        // the +1 at the end here handles the situation of a Stack of size zero
        myElements = Arrays.copyOf(myElements, myElements.length * 2 + 1);
    }

}

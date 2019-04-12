/*
 * TCSS 342
 */

package exceptions;

/**
 * ElementNotFoundException represents the situation in which a target element 
 * is not present in a collection.
 *
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 */
public class ElementNotFoundException extends RuntimeException
{
    /** A version ID for serialization.*/
    private static final long serialVersionUID = -8985982736375193844L;

    /**
     * Sets up this exception with an appropriate message.
     * 
     * @param theCollection the collection name to list in the custom error message
     */
    public ElementNotFoundException(final String theCollection)
    {
        super("The target element is not in this " + theCollection);
    }
}


package exceptions;

/**
 * Represents the situation in which a collection is empty.
 *
 * @author Lewis and Chase
 * @author Alan Fowler - formatted for TCSS 342
 * @version 1.1
 */
public class EmptyCollectionException extends RuntimeException {
    
    /** A generated version ID for Serialization.*/
    private static final long serialVersionUID = -6409273709413115088L;

    /**
     * Sets up this exception with an appropriate message.
     * 
     * @param theCollection the name of the collection
     */
    public EmptyCollectionException(final String theCollection) {
        super("The " + theCollection + " is empty.");
    }
}

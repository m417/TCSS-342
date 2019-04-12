/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package structures;

/**
 * An output-restricted double-ended queue.
 * 
 * @author Matthew Chan
 * @version January 30, 2019
 * 
 * @param <E> the type of the element
 */
public class LinkedOutputRestrictedDeque<E> extends LinkedQueue<E>
                implements OutputRestrictedDequeADT<E> {

    /**
     * Initialize an empty queue.
     */
    public LinkedOutputRestrictedDeque() {
        super();
    }

    @Override
    public void enqueueAtFront(final E theElement) {
        if (mySize == 0) {
            myFront = new Node<E>(theElement);
            myRear = myFront;
        } else {
            final Node<E> newFront = new Node<E>(theElement, myFront);
            myFront = newFront;
        }
        mySize++;
    }

}

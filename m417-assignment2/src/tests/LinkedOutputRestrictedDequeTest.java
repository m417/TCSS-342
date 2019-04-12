/*
 * TCSS 342 – Winter 2019 - Assignment 2
 */
package tests;

import static org.junit.Assert.*;

import exceptions.EmptyCollectionException;
import org.junit.Before;
import org.junit.Test;
import structures.LinkedOutputRestrictedDeque;
import structures.OutputRestrictedDequeADT;

/**
 * Unit tests of the LinkedQueue class.
 * 
 * @author Matthew Chan
 * @version January 30, 2019
 */
public class LinkedOutputRestrictedDequeTest {

    /** A LinkedOutputRestrictedDeque for testing. */
    private LinkedOutputRestrictedDeque<Integer> myQueue;
    
    /**
     * Test fixture.
     */
    @Before
    public void setUp() {
        myQueue = new LinkedOutputRestrictedDeque<>();
    }

    /**
     * Test enqueue method.
     */
    @Test
    public void testEnqueue() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals((int) queue.first(), 3);
    }
    
    /**
     * Test enqueueAtFront method.
     */
    @Test
    public void testEnqueueAtFront() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueueAtFront(5);
        assertEquals((int) queue.first(), 5);
    }
    
    /**
     * Test enqueueAtFront method to an empty list.
     */
    @Test
    public void testEnqueueAtFrontEmptyList() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueueAtFront(1);
        assertEquals((int) queue.first(), 1);
    }

    /**
     * Test dequeue method.
     */
    @Test
    public void testDequeue() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals((int) queue.dequeue(), 3);
    }
    
    /**
     * Test dequeue method for an empty queue.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testDequeueEmptyQueue() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.dequeue();
    }

    /**
     * Test first method.
     */
    @Test
    public void testFirst() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals((int) queue.first(), 3);
    }
    
    /**
     * Test first method for an empty queue.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testFirstEmptyQueue() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.first();
    }

    /**
     * Test size method.
     */
    @Test
    public void testSize() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(queue.size(), 3);
    }

    /**
     * Test isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        final OutputRestrictedDequeADT<Integer> queueOne = new LinkedOutputRestrictedDeque<>();
        assertEquals(queueOne.isEmpty(), true);
        final OutputRestrictedDequeADT<Integer> queueTwo = new LinkedOutputRestrictedDeque<>();
        queueTwo.enqueue(1);
        assertEquals(queueTwo.isEmpty(), false);
    }

    /**
     * Test toString method.
     */
    @Test
    public void testToString() {
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(2);
        myQueue.enqueue(1);
        assertEquals("front -> 1, 2, 3, 2, 1", myQueue.toString());
    }
    
    /**
     * Test toString method for an empty queue.
     */
    @Test
    public void testToStringEmptyQueue() {
        final OutputRestrictedDequeADT<Integer> queue = new LinkedOutputRestrictedDeque<>();
        assertEquals("", queue.toString());
    }

}

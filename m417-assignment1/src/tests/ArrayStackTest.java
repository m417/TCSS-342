/* 
 * TCSS 342
 */

package tests;

import static org.junit.Assert.*;

import exceptions.EmptyCollectionException;
import org.junit.Before;
import org.junit.Test;
import structures.ArrayStack;

/**
 * Unit tests of the ArrayStack class.
 * 
 * @author Alan Fowler
 * @version 1.1
 */
public class ArrayStackTest {
    
    // test fixture
    
    /**
     * A GenericSimpleArrayStack to test.
     */
    private ArrayStack<Integer> myStack;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myStack = new ArrayStack<>(); // java 7 diamond operator
    }

    /**
     * Test method for {@link structures.ArrayStack#ArrayStack()}.
     */
    @Test
    public void testArrayStack() {
        assertNotNull("myStack was not instantiated!", myStack);
        assertEquals("myStack should be size zero!", 0, myStack.size());
        assertTrue("myStack should be empty!", myStack.isEmpty());
        assertEquals("incorrect toString() for empty Stack!",
                     "Empty Stack", myStack.toString());
    }
    
    /**
     * Test method for {@link structures.ArrayStack#ArrayStack(int)}.
     */
    @Test
    public void testArrayStackOverloadedConstructor() {
        final ArrayStack<Integer> stack2 = new ArrayStack<>(50);
        assertNotNull("stack2 was not instantiated!", stack2);
        assertEquals("stack2 should be size zero!", 0, stack2.size());
        assertTrue("stack2 should be empty!", stack2.isEmpty());
        assertEquals("incorrect toString() for empty Stack!",
                     "Empty Stack", stack2.toString());
    }

    /**
     * Test method for {@link structures.ArrayStack#push(java.lang.Object)}.
     */
    @Test
    public void testPush() {
        // using toString() in tests means that the format of toString() is specified
        // OR it means we are doing white box testing
        // The advantage of using toString() is that we can test all contents in one shot
        String test = "";
        for (int i = 0; i <= 10; i++) {
            test = i + "\n" + test;
            myStack.push(i);
            assertEquals("push() failed to update the contents of the Stack as expected!",
                         test, myStack.toString());
            assertEquals("push() failed to update the size of the Stack.",
                         i + 1, myStack.size());
        }
    }

    /**
     * Test method for {@link structures.ArrayStack#pop()}.
     */
    @Test
    public void testPop() {
        String test = "";
        for (int i = 0; i <= 10; i++) {
            test = i + "\n" + test;
            myStack.push(i);
        }
        for (int i = 10; i > 0; i--) {
            assertEquals("pop() returned an unexpected result!", i, (int) myStack.pop());
            assertEquals("pop() did not update the size of the stack as expected",
                         i, myStack.size());
            test = test.substring(test.indexOf('\n') + 1);
            assertEquals("pop() failed to update the contents of the Stack as expected!",
                         test, myStack.toString());
        }
        assertEquals("pop() returned an unexpected result!", 0, (int) myStack.pop());
        assertEquals("pop() did not update the size of the stack as expected",
                     0, myStack.size());
        assertEquals("pop() failed to update the contents of the Stack as expected!",
                     "Empty Stack", myStack.toString());
    }
    
    /**
     * Test method for {@link GenericSimpleArrayStack#pop()}.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testPopEmpty() {
        myStack.pop();
    }

    /**
     * Test method for {@link structures.ArrayStack#peek()}.
     */
    @Test
    public void testPeek() {
        String test = "";
        for (int i = 0; i <= 10; i++) {
            test = i + "\n" + test;
            myStack.push(i);          
            assertEquals("peek() returned an unexpected result!", (Integer) i, myStack.peek());
            // OR
            assertEquals("peek() returned an unexpected result!", i, (int) myStack.peek());
        }
    }

    /**
     * Test method for {@link GenericSimpleArrayStack#peek()}.
     */
    @Test(expected = EmptyCollectionException.class)
    public void testPeekEmpty() {
        myStack.peek();
    }

}

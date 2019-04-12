/*
 * TCSS 342 – Winter 2019 - Assignment 1
 */
package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import program.StackUtilities;

/**
 * JUnit test class for StackUtilities.
 * 
 * @author Matthew Chan
 * @version January 16, 2019
 */
public class StackUtilitiesTest {
    
    /**
     * Test method for decimaltoBinary.
     */
    @Test
    public void testDecimalToBinary() {
        assertFalse(StackUtilities.decimalToBinary(13).equals("13"));
        assertTrue(StackUtilities.decimalToBinary(13).equals("1101"));
        assertTrue(StackUtilities.decimalToBinary(123456789).
                   equals("111010110111100110100010101"));
    }

    /**
     * Test method for decimaltoBinary.
     * Test for negative input, expected IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecimalToBinaryEx1() {
        StackUtilities.decimalToBinary(-1);
    }
    
    /**
     * Test method for decimaltoBinary.
     * Test for zero input, expected IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDecimalToBinaryEx2() {
        StackUtilities.decimalToBinary(0);
    }
    
}

/*
 * TCSS 342
 */

package programs;

/**
 * ExpressionTreeOp represents an element in an expression tree.
 * 
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 */
public class ExpressionTreeOp 
{
    /** The integer type of the expression. */
    private final int myTermType;
    
    /** The operand for the expression. */
    private final char myOperator;
    
    /** The value for the expression. */
    private final int myValue;

    /**
     * Creates a new expression tree object with the specified data.
     *
     * @param theType the integer type of the expression
     * @param theOp   the operand for the expression
     * @param theVal  the value for the expression
     */
    public ExpressionTreeOp(final int theType, final char theOp, final int theVal) 
    {
        myTermType = theType;
        myOperator = theOp;
        myValue = theVal;
    }

    /**
     * Returns true if this object is an operator and false otherwise.
     *
     * @return true if this object is an operator, false otherwise
     */
    public boolean isOperator() 
    {
        return myTermType == 1;
    }
    
    /**
     *Returns the operator of this expression tree object.
     *
     * @return the character representation of the operator
     */
    public char getOperator() 
    {
        return myOperator;
    }

    /**
     * Returns the value of this expression tree object.
     *
     * @return the value of this expression tree object
     */
    public int getValue() 
    {
        return myValue;
    }
    
    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder();
        if (myTermType == 1)
        {
            sb.append(myOperator);
        }
        else
        {
            sb.append(myValue);
        }
        return sb.toString();
    }
}
    


/*
 * TCSS 342
 */

package programs;

import java.util.Scanner;
import structures.ArrayStack;

/**
 * PostfixEvaluator this modification of our stack example uses a 
 * stack to create an expression tree from a VALID integer postfix expression 
 * and then uses a recursive method from the ExpressionTree class to 
 * evaluate the tree.
 * 
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 */
public class PostfixEvaluator    
{
    /** A Stack used to create an expression tree. */
    private final ArrayStack<ExpressionTree> myTreeStack;
    
    /**
     * Sets up this evaluator by creating a new stack.
     */
    public PostfixEvaluator()
    {
        myTreeStack = new ArrayStack<ExpressionTree>();
    }

    /**
     * Retrieves and returns the next operand off of this tree stack.
     *
     * @param theTreeStack  the tree stack from which the operand will be returned
     * @return the next operand off of this tree stack
     */
    private ExpressionTree getOperand(final ArrayStack<ExpressionTree> theTreeStack)
    {
        final ExpressionTree temp;
        temp = theTreeStack.pop();
        
        return temp;
    }
    
    /**
     * Evaluates the specified postfix expression by building and evaluating
     * an expression tree. 
     *
     * @param theExpression string representation of a postfix expression
     * @return value of the given expression
     */
    public int evaluate(final String theExpression)
    {
        ExpressionTree operand1;
        ExpressionTree operand2;
        char operator;
        String tempToken;

        final Scanner parser = new Scanner(theExpression);
        
        while (parser.hasNext()) 
        {
            tempToken = parser.next();
            operator = tempToken.charAt(0);
            
            if ((operator == '+') || (operator == '-')
                                  || (operator == '*')
                                  || (operator == '/'))
            {
                operand1 = getOperand(myTreeStack);
                operand2 = getOperand(myTreeStack);
                myTreeStack.push(new ExpressionTree(
                    new ExpressionTreeOp(1, operator, 0),
                                         operand2,
                                         operand1));
            }
            else
            {
                myTreeStack.push(new ExpressionTree(
                    new ExpressionTreeOp(2, ' ', Integer.parseInt(tempToken)),
                    null,
                    null));
            }
            
        }
        parser.close();
        return (myTreeStack.peek()).evaluateTree();        
    }
    
    /**
     * Returns the expression tree associated with this postfix evaluator. 
     *
     * @return the expression tree associated with this postfix evaluator
     */
    public ExpressionTree getTree()
    {
        return myTreeStack.peek();
    }
}
